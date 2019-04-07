package xin.cymall.controller;

import java.util.List;
import java.util.Map;
import xin.cymall.common.enumresource.StateEnum;
import xin.cymall.common.log.SysLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

import xin.cymall.entity.EnMaintainPlan;
import xin.cymall.service.EnMaintainPlanService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 设备维保计划
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-07 18:35:07
 */
@Controller
@RequestMapping("enmaintainplan")
public class EnMaintainPlanController {
	@Autowired
	private EnMaintainPlanService enMaintainPlanService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("enmaintainplan:list")
    public String list() {
        return "enmaintainplan/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("enmaintainplan:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EnMaintainPlan> enMaintainPlanList = enMaintainPlanService.queryList(query);
		int total = enMaintainPlanService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(enMaintainPlanList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("enmaintainplan:save")
    public String add(){
        return "enmaintainplan/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("enmaintainplan:update")
    public String edit(Model model, @PathVariable("id") String id){
		EnMaintainPlan enMaintainPlan = enMaintainPlanService.queryObject(id);
        model.addAttribute("model",enMaintainPlan);
        return "enmaintainplan/edit";
    }

    /**
     * 跳转到详情页面
     */
    @RequestMapping("detail/{id}")
    @RequiresPermissions("encollector:info")
    public String detail(Model model, @PathVariable("id") String id){
        EnMaintainPlan enMaintainPlan = enMaintainPlanService.queryObject(id);
        model.addAttribute("model",enMaintainPlan);
        return "encollector/info";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("enmaintainplan:info")
    public R info(@PathVariable("id") String id){
        EnMaintainPlan enMaintainPlan = enMaintainPlanService.queryObject(id);
        return R.ok().put("enMaintainPlan", enMaintainPlan);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存设备维保计划")
	@RequestMapping("/save")
	@RequiresPermissions("enmaintainplan:save")
	public R save(@RequestBody EnMaintainPlan enMaintainPlan){
		enMaintainPlanService.save(enMaintainPlan);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改设备维保计划")
	@RequestMapping("/update")
	@RequiresPermissions("enmaintainplan:update")
	public R update(@RequestBody EnMaintainPlan enMaintainPlan){
		enMaintainPlanService.update(enMaintainPlan);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用设备维保计划")
    @RequestMapping("/enable")
    @RequiresPermissions("enmaintainplan:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		enMaintainPlanService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用设备维保计划")
    @RequestMapping("/limit")
    @RequiresPermissions("enmaintainplan:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		enMaintainPlanService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除设备维保计划")
	@RequestMapping("/delete")
	@RequiresPermissions("enmaintainplan:delete")
	public R delete(@RequestBody String[] ids){
		enMaintainPlanService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
