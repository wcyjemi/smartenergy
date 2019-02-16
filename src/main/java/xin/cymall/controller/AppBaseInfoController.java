package xin.cymall.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.enumresource.StateEnum;
import xin.cymall.common.exception.MyException;
import xin.cymall.common.log.SysLog;
import xin.cymall.common.shiro.ShiroUtils;
import xin.cymall.common.utils.*;
import xin.cymall.entity.AppBaseInfo;
import xin.cymall.entity.AppVersion;
import xin.cymall.entity.Commpara;
import xin.cymall.entity.SysRole;
import xin.cymall.service.AppBaseInfoService;
import xin.cymall.service.AppVersionService;
import xin.cymall.service.CommparaService;

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
@RequestMapping("appinfo")
public class AppBaseInfoController extends AbstractController{
	@Autowired
	private AppBaseInfoService appBaseInfoService;
	@Autowired
	private AppVersionService appVersionService;

    @RequestMapping("/list")
    public String list() {
        return "appinfo/list";
    }
	/**
	 * 列表
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("appinfo:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        List<AppBaseInfo> commparaList = appBaseInfoService.queryList(query);
		int total = appBaseInfoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(commparaList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}
    
    @ResponseBody
    @RequestMapping("/findAll")
    @RequiresPermissions("appinfo:list")
    public R findAll(@RequestParam(value = "hasSysUser",required = false) String hasSysUser,@RequestParam(value = "appStatus",required = false) String appStatus) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(hasSysUser)&&getUserId() != Constant.SUPER_ADMIN){
            map.put("sysUser",getUserId());
        }
        map.put("appStatus",appStatus);
        List<AppBaseInfo> list = appBaseInfoService.queryList(map);
        List<EnumBean> values = new ArrayList<>();
        for (AppBaseInfo appBaseInfo : list) {
            EnumBean enumBean = new EnumBean();
            enumBean.setCode(appBaseInfo.getId() + "");
            enumBean.setValue(appBaseInfo.getAppName());
            values.add(enumBean);
        }

        return R.ok().put("data", values);
    }
    

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("appinfo:save")
    public String add(){
        return "appinfo/add";
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存应用信息")
	@RequestMapping("/save")
	@RequiresPermissions("appinfo:save")
	public R save(@RequestBody AppBaseInfo appBaseInfo){
        //同一参数编码 下的 参数值不能相同
        List<AppBaseInfo> appBaseInfos = appBaseInfoService.findByVerify(appBaseInfo);
        if(appBaseInfos!=null&&appBaseInfos.size()>0){
           throw  new MyException("应用'"+appBaseInfo.getAppName()+"'已存在");
        }
        try {
        	appBaseInfo.setOpraUser(ShiroUtils.getUserId());
        	appBaseInfoService.save(appBaseInfo);
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
    @RequiresPermissions("appinfo:update")
    public String edit(Model model, @PathVariable("id") Integer id){
		AppBaseInfo appBaseInfo = appBaseInfoService.queryObject(id);
        model.addAttribute("model",appBaseInfo);
        return "appinfo/edit";
    }
    
    /**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改应用信息")
	@RequestMapping("/update")
	@RequiresPermissions("appinfo:update")
	public R update(@RequestBody AppBaseInfo appBaseInfo){
        AppBaseInfo appBaseInfoOld = appBaseInfoService.queryObject(appBaseInfo.getId());
        if (appBaseInfoOld.getAppStatus().equals("1")){
            throw new MyException("应用已上架不能修改");
        }
    	List<AppBaseInfo> appBaseInfos = appBaseInfoService.findByVerify(appBaseInfo);
        if(appBaseInfos!=null&&appBaseInfos.size()>0){
           throw  new MyException("应用'"+appBaseInfo.getAppName()+"'已存在");
        }
        try {
        	appBaseInfo.setOpraUser(ShiroUtils.getUserId());
        	appBaseInfoService.update(appBaseInfo);
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
    @SysLog("应用信息批量上架")
	@RequestMapping("/upOnline")
	@RequiresPermissions("appinfo:upOnline")
	public R upOnline(@RequestBody Integer[] ids){
        try {
        	appBaseInfoService.updateBatch(ids, "1");
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
    @SysLog("应用信息批量下架")
    @RequestMapping("/downOnline")
    @RequiresPermissions("appinfo:downOnline")
    public R downOnline(@RequestBody Integer[] ids){
    	try {
    		appBaseInfoService.updateBatch(ids, "0");
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
    @SysLog("删除APP基本信息")
	@RequestMapping("/delete")
	@RequiresPermissions("appinfo:delete")
	public R delete(@RequestBody Integer[] ids){
        ArrayList<String> hasVersionApp = new ArrayList<>();
        ArrayList<String> hasPubApp = new ArrayList<>();
        for (int i=0;i<ids.length;i++){
            AppBaseInfo appBaseInfo = appBaseInfoService.queryObject(ids[i]);
            if (appBaseInfo.getAppStatus().equals("1")){
                hasPubApp.add(appBaseInfo.getAppName());
            }
            Map<String,Object> param = new HashMap<>();
            param.put("appId",ids[i]);
            Integer countAppver = appVersionService.queryTotal(param);
            if (countAppver != null && countAppver>0){
                hasVersionApp.add(appBaseInfo.getAppName());
            }
        }
        if (hasPubApp.size()>0){
            return R.error(hasPubApp.toString()+" 存在已上架的应用,不可删除!");
        }
        if (hasVersionApp.size()>0){
            return R.error(hasVersionApp.toString()+" 存在发布的应用版本,不可删除!");
        }else {
            appBaseInfoService.deleteBatch(ids);
        }
		return R.ok();
	}
    
	
}
