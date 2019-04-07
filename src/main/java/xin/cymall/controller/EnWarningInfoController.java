package xin.cymall.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.enumresource.StateEnum;
import xin.cymall.common.log.SysLog;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;
import xin.cymall.entity.EnWarningInfo;
import xin.cymall.service.EnWarningInfoService;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-02 15:53:34
 */
@Controller
@RequestMapping("enwarninginfo")
public class EnWarningInfoController {
	@Autowired
	private EnWarningInfoService enWarningInfoService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("enwarninginfo:list")
    public String list() {
        return "enwarninginfo/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("enwarninginfo:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EnWarningInfo> enWarningInfoList = enWarningInfoService.queryList(query);
		int total = enWarningInfoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(enWarningInfoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("enwarninginfo:save")
    public String add(){
        return "enwarninginfo/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("enwarninginfo:update")
    public String edit(Model model, @PathVariable("id") String id){
		EnWarningInfo enWarningInfo = enWarningInfoService.queryObject(id);
        model.addAttribute("model",enWarningInfo);
        return "enwarninginfo/edit";
    }

    /**
     * 跳转到详情页面
     */
    @RequestMapping("detail/{id}")
    @RequiresPermissions("enwarninginfo:info")
    public String detail(Model model, @PathVariable("id") String id){
        EnWarningInfo enWarningInfo = enWarningInfoService.queryObject(id);
        model.addAttribute("model",enWarningInfo);
        return "enwarninginfo/info";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("enwarninginfo:info")
    public R info(@PathVariable("id") String id){
        EnWarningInfo enWarningInfo = enWarningInfoService.queryObject(id);
        return R.ok().put("enWarningInfo", enWarningInfo);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("enwarninginfo:save")
	public R save(@RequestBody EnWarningInfo enWarningInfo){
		enWarningInfoService.save(enWarningInfo);
		return R.ok();
	}

}
