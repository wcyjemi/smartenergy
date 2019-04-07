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
import xin.cymall.entity.EnInstructions;
import xin.cymall.service.EnInstructionsService;

import java.util.List;
import java.util.Map;


/**
 * 数据项信息
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-03 10:42:59
 */
@Controller
@RequestMapping("eninstructions")
public class EnInstructionsController {
	@Autowired
	private EnInstructionsService enInstructionsService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("eninstructions:list")
    public String list() {
        return "eninstructions/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("eninstructions:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EnInstructions> enInstructionsList = enInstructionsService.queryList(query);
		int total = enInstructionsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(enInstructionsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("eninstructions:save")
    public String add(){
        return "eninstructions/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("eninstructions:update")
    public String edit(Model model, @PathVariable("id") String id){
		EnInstructions enInstructions = enInstructionsService.queryObject(id);
        model.addAttribute("model",enInstructions);
        return "eninstructions/edit";
    }

    /**
     * 跳转到详情页面
     */
    @RequestMapping("detail/{id}")
    @RequiresPermissions("encollector:info")
    public String detail(Model model, @PathVariable("id") String id){
        EnInstructions enInstructions = enInstructionsService.queryObject(id);
        model.addAttribute("model",enInstructions);
        return "encollector/info";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("eninstructions:info")
    public R info(@PathVariable("id") String id){
        EnInstructions enInstructions = enInstructionsService.queryObject(id);
        return R.ok().put("enInstructions", enInstructions);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存数据项信息")
	@RequestMapping("/save")
	@RequiresPermissions("eninstructions:save")
	public R save(@RequestBody EnInstructions enInstructions){
		enInstructionsService.save(enInstructions);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改数据项信息")
	@RequestMapping("/update")
	@RequiresPermissions("eninstructions:update")
	public R update(@RequestBody EnInstructions enInstructions){
		enInstructionsService.update(enInstructions);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用数据项信息")
    @RequestMapping("/enable")
    @RequiresPermissions("eninstructions:update")
    public R enable(@RequestBody String[] ids){
        String stateValue= StateEnum.ENABLE.getCode();
		enInstructionsService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用数据项信息")
    @RequestMapping("/limit")
    @RequiresPermissions("eninstructions:update")
    public R limit(@RequestBody String[] ids){
        String stateValue= StateEnum.LIMIT.getCode();
		enInstructionsService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除数据项信息")
	@RequestMapping("/delete")
	@RequiresPermissions("eninstructions:delete")
	public R delete(@RequestBody String[] ids){
		enInstructionsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
