package xin.cymall.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.exception.MyException;
import xin.cymall.common.log.SysLog;
import xin.cymall.common.shiro.ShiroUtils;
import xin.cymall.common.utils.*;
import xin.cymall.entity.AppBaseInfo;
import xin.cymall.entity.AppVersion;
import xin.cymall.entity.File;
import xin.cymall.service.AppBaseInfoService;
import xin.cymall.service.AppVersionService;
import xin.cymall.service.FileService;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * APP基本信息管理
 * @author wcy
 * @date 2019年1月2日15:14:16
 */
@Controller
@RequestMapping("appver")
public class AppVersionController extends AbstractController{
    @Autowired
    private AppBaseInfoService appBaseInfoService;
	@Autowired
	private AppVersionService appVersionService;
	@Autowired
	private FileService fileService;

    @RequestMapping("/list")
    public String list() {
        return "appver/list";
    }
	/**
	 * 列表
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("appver:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        if (getUserId() != Constant.SUPER_ADMIN){
            params.put("sysUser",getUserId());
        }
        Query query = new Query(params);
        List<AppVersion> commparaList = appVersionService.queryList(query);
		int total = appVersionService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(commparaList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}
    
    @ResponseBody
    @RequestMapping("/findAll")
    @RequiresPermissions("appver:list")
    public R findAll() {
        Map<String, Object> map = new HashMap<>();
        List<AppVersion> list = appVersionService.queryList(map);
        List<EnumBean> values = new ArrayList<>();
        for (AppVersion appVersion : list) {
            EnumBean enumBean = new EnumBean();
            enumBean.setCode(appVersion.getId() + "");
            enumBean.setValue(appVersion.getAppName());
            values.add(enumBean);
        }
        return R.ok().put("data", values);
    }

    /**
     * 跳转到选择用户可管理APP
     */
    @RequestMapping("/toSelectApp")
    @RequiresPermissions("appver:save")
    public String toSelectApp(){
        return "appver/selectApp";
    }

    @ResponseBody
    @SysLog("验证APP基本信息")
    @RequestMapping("/verfiyapp")
    @RequiresPermissions("appver:save")
    public R verfiyApp(@RequestBody AppVersion appVersion){
        if (appVersion.getAppId()==null){
            return R.error("请选择应用！");
        }
        AppBaseInfo appBaseInfo = appBaseInfoService.queryObject(Integer.parseInt(appVersion.getAppId()+""));
        if (appBaseInfo == null){
            return R.error("请选择应用！");
        }else {
            return R.ok();
        }
    }
    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("appver:save")
    public String add(Model model,@RequestParam Map<String,Object> param){
        AppVersion appVersion = new AppVersion();
        appVersion.setAppId(Long.parseLong(param.get("appId").toString()));
        AppBaseInfo appBaseInfo = appBaseInfoService.queryObject(Integer.parseInt(appVersion.getAppId()+""));
        appVersion.setAppName(appBaseInfo.getAppName());
        appVersion.setAppIcon(appBaseInfo.getAppIcon());
        appVersion.setAppEnname(appBaseInfo.getAppEnname());
        model.addAttribute("model",appVersion);
        return "appver/add";
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存APP版本信息")
	@RequestMapping(value = "/save")
	@RequiresPermissions("appver:save")
	public R save(@RequestBody AppVersion appVersion){
        //校验版本是否存在
        List<AppVersion> appVersions = appVersionService.findByVerify(appVersion);
        AppVersion appver = new AppVersion();
        appver.setAppId(appVersion.getAppId());
        appver.setAppType(appVersion.getAppType());
        AppVersion appLastVersion = appVersionService.queryLastAppVer(appver);
        if (appLastVersion!=null){
            if (appLastVersion.getAppInnerverno()>=appVersion.getAppInnerverno()){
                throw new MyException("应用'"+appVersion.getAppName()+"'版本不能低于当前最新版本");
            }
            String[] lastVerNo = appLastVersion.getAppOutverno().split("\\.");
            String[] currentVerNo = appVersion.getAppOutverno().split("\\.");
            String lastNo = "";
            String currentNo = "";
            for (int i = 0;i<lastVerNo.length;i++){
                if (i==0 && i==(lastVerNo.length-1)){
                    lastNo = lastNo + lastVerNo[i];
                }else if (i==0 && i != (lastVerNo.length-1)){
                    lastNo = lastNo + lastVerNo[i]+".";
                }else{
                    lastNo = lastNo + lastVerNo[i];
                }
            }
            for (int i = 0;i<currentVerNo.length;i++){
                if (i==0 && i==(currentVerNo.length-1)){
                    currentNo = currentNo + currentVerNo[i];
                }else if (i==0 && i != (currentVerNo.length-1)){
                    currentNo = currentNo + currentVerNo[i]+".";
                }else{
                    currentNo = currentNo + currentVerNo[i];
                }
            }
            BigDecimal lastVerNoBigDc = new BigDecimal(lastNo).setScale(10,BigDecimal.ROUND_HALF_UP);
            BigDecimal currentVerNoBigDc = new BigDecimal(currentNo).setScale(10,BigDecimal.ROUND_HALF_UP);
            if (lastVerNoBigDc.compareTo(currentVerNoBigDc)>=0){
                throw new MyException("应用'"+appVersion.getAppName()+"'版本不能低于当前最新版本");
            }
            if(appVersions!=null&&appVersions.size()>0){
                throw new MyException("应用'"+appVersion.getAppOutverno()+"'版本已存在");
            }
        }

        List<File> fileList = fileService.getByRelationId(appVersion.getAppUrl());
        if (fileList.size()<=0){
            throw new MyException("请上传安装包！");
        }
        try {
			appVersion.setAppOprauser(ShiroUtils.getUserId());
        	appVersionService.save(appVersion);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return R.error();
		}
		return R.ok();
	}
    
    
    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("appver:update")
    public String edit(Model model, @PathVariable("id") Integer id){
		AppVersion appVersion = appVersionService.queryObject(id);
        model.addAttribute("model",appVersion);
        return "appver/edit";
    }
    
    /**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改APP版本信息")
	@RequestMapping("/update")
	@RequiresPermissions("appver:update")
	public R update(@RequestBody AppVersion appVersion){
        AppVersion appVersionRe = appVersionService.queryObject(Integer.parseInt(appVersion.getId()+""));
    	List<AppVersion> appVersions = appVersionService.findByVerify(appVersion);
        if(appVersionRe.getAppPubstatus().equals("1")){
            throw  new MyException("应用'"+appVersion.getAppName()+"'当前版本已在发布状态，无法修改！");
        }
        if(appVersions!=null&&appVersions.size()>0){
            throw  new MyException("应用'"+appVersion.getAppOutverno()+"'版本已存在");
        }
        List<File> fileList = fileService.getByRelationId(appVersion.getAppUrl());
        if (fileList.size()<=0){
            throw new MyException("请上传安装包！");
        }
        try {
        	appVersion.setAppOprauser(ShiroUtils.getUserId());
        	appVersionService.update(appVersion);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return R.error();
		}
		return R.ok();
	}
    
    /**
	 * 修改
	 */
    @ResponseBody
    @SysLog("APP版本批量发布")
	@RequestMapping("/upOnline")
	@RequiresPermissions("appver:upOnline")
	public R upOnline(@RequestBody Integer[] ids){
        try {
        	appVersionService.updateBatch(ids, "1");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return R.error();
		}
		return R.ok();
	}
    
    /**
     * 修改
     */
    @ResponseBody
    @SysLog("APP版本批量停用")
    @RequestMapping("/downOnline")
    @RequiresPermissions("appver:downOnline")
    public R downOnline(@RequestBody Integer[] ids){
    	try {
    		appVersionService.updateBatch(ids, "0");
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    		return R.error();
    	}
    	return R.ok();
    }
    
    /**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除APP版本")
	@RequestMapping("/delete")
	@RequiresPermissions("appver:delete")
	public R delete(@RequestBody Integer[] ids){
        for (int i=0;i<ids.length;i++){
            AppVersion appVersionRe = appVersionService.queryObject(ids[i]);
            if(appVersionRe.getAppPubstatus().equals("1")){
                return R.error("所选的版本中存在已发布的版本，无法进行删除！");
            }
        }
		appVersionService.deleteBatch(ids);
		return R.ok();
	}
    
	
}
