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

import xin.cymall.entity.EnConcentrator;
import xin.cymall.service.EnConcentratorService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 集中器信息表
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-03-28 14:44:28
 */
@Controller
@RequestMapping("enconcentrator")
public class EnConcentratorController {
	@Autowired
	private EnConcentratorService enConcentratorService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("enconcentrator:list")
    public String list() {
        return "enconcentrator/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("enconcentrator:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EnConcentrator> enConcentratorList = enConcentratorService.queryList(query);
		int total = enConcentratorService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(enConcentratorList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("enconcentrator:save")
    public String add(){
        return "enconcentrator/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("enconcentrator:update")
    public String edit(Model model, @PathVariable("id") String id){
		EnConcentrator enConcentrator = enConcentratorService.queryObject(id);
        model.addAttribute("model",enConcentrator);
        return "enconcentrator/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("enconcentrator:info")
    public R info(@PathVariable("id") String id){
        EnConcentrator enConcentrator = enConcentratorService.queryObject(id);
        return R.ok().put("enConcentrator", enConcentrator);
    }


    /**
     * 跳转到详情页面
     */

    @RequestMapping("details/{id}")
    @RequiresPermissions("enconcentrator:info")
    public String details(Model model, @PathVariable("id") String id){
        EnConcentrator enConcentrator = enConcentratorService.queryObject(id);
        model.addAttribute("model",enConcentrator);
        return "enconcentrator/info";
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存集中器信息表")
	@RequestMapping("/save")
	@RequiresPermissions("enconcentrator:save")
	public R save(@RequestBody EnConcentrator enConcentrator){
		enConcentratorService.save(enConcentrator);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改集中器信息表")
	@RequestMapping("/update")
	@RequiresPermissions("enconcentrator:update")
	public R update(@RequestBody EnConcentrator enConcentrator){
		enConcentratorService.update(enConcentrator);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用集中器信息表")
    @RequestMapping("/enable")
    @RequiresPermissions("enconcentrator:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		enConcentratorService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用集中器信息表")
    @RequestMapping("/limit")
    @RequiresPermissions("enconcentrator:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		enConcentratorService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除集中器信息表")
	@RequestMapping("/delete")
	@RequiresPermissions("enconcentrator:delete")
	public R delete(@RequestBody String[] ids){
		enConcentratorService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
