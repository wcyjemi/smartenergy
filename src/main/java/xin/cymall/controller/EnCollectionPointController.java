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

import xin.cymall.entity.EnCollectionPoint;
import xin.cymall.service.EnCollectionPointService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 采集点信息表
 * 
 * @author wcy
 * @email 228112142@qq.com
 * @date 2019-03-19 11:10:52
 */
@Controller
@RequestMapping("/encollectionpoint")
public class EnCollectionPointController {
	@Autowired
	private EnCollectionPointService enCollectionPointService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("encollectionpoint:list")
    public String list() {
        return "collectionpoint/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("encollectionpoint:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EnCollectionPoint> enCollectionPointList = enCollectionPointService.queryList(query);
		int total = enCollectionPointService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(enCollectionPointList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("encollectionpoint:save")
    public String add(){
        return "collectionpoint/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("encollectionpoint:update")
    public String edit(Model model, @PathVariable("id") String id){
		EnCollectionPoint enCollectionPoint = enCollectionPointService.queryObject(id);
        model.addAttribute("model",enCollectionPoint);
        return "collectionpoint/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("encollectionpoint:info")
    public R info(@PathVariable("id") String id){
        EnCollectionPoint enCollectionPoint = enCollectionPointService.queryObject(id);
        return R.ok().put("enCollectionPoint", enCollectionPoint);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存采集点信息表")
	@RequestMapping("/save")
	@RequiresPermissions("encollectionpoint:save")
	public R save(@RequestBody EnCollectionPoint enCollectionPoint){
		enCollectionPointService.save(enCollectionPoint);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改采集点信息表")
	@RequestMapping("/update")
	@RequiresPermissions("encollectionpoint:update")
	public R update(@RequestBody EnCollectionPoint enCollectionPoint){
		enCollectionPointService.update(enCollectionPoint);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用采集点信息表")
    @RequestMapping("/enable")
    @RequiresPermissions("encollectionpoint:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		enCollectionPointService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用采集点信息表")
    @RequestMapping("/limit")
    @RequiresPermissions("encollectionpoint:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		enCollectionPointService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除采集点信息表")
	@RequestMapping("/delete")
	@RequiresPermissions("encollectionpoint:delete")
	public R delete(@RequestBody String[] ids){
		enCollectionPointService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
