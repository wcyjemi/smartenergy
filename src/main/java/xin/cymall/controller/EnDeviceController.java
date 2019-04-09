package xin.cymall.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.enumresource.StateEnum;
import xin.cymall.common.log.SysLog;
import xin.cymall.common.utils.EnumBean;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;
import xin.cymall.entity.EnDevice;
import xin.cymall.service.EnDeviceService;

import java.util.List;
import java.util.Map;


/**
 * 设备信息表
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-03 15:11:53
 */
@Controller
@RequestMapping("endevice")
public class EnDeviceController {
	@Autowired
	private EnDeviceService enDeviceService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("endevice:list")
    public String list() {
        return "endevice/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("endevice:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EnDevice> enDeviceList = enDeviceService.queryList(query);
		int total = enDeviceService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(enDeviceList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}

    /**
     * 所有数据
     */
    @ResponseBody
    @RequestMapping("/listAllData")
    public R listAllData(){
        //查询列表数据
        List<EnumBean> enDeviceList = enDeviceService.queryAllList();
        return R.ok().put("data", enDeviceList);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("endevice:save")
    public String add(){
        return "endevice/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("endevice:update")
    public String edit(Model model, @PathVariable("id") String id){
		EnDevice enDevice = enDeviceService.queryObject(id);
        model.addAttribute("model",enDevice);
        return "endevice/edit";
    }

    /**
     * 跳转到详情页面
     */
    @RequestMapping("detail/{id}")
    @RequiresPermissions("encollector:info")
    public String detail(Model model, @PathVariable("id") String id){
        EnDevice enDevice = enDeviceService.queryObject(id);
        model.addAttribute("model",enDevice);
        return "encollector/info";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("endevice:info")
    public R info(@PathVariable("id") String id){
        EnDevice enDevice = enDeviceService.queryObject(id);
        return R.ok().put("enDevice", enDevice);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存设备信息表")
	@RequestMapping("/save")
	@RequiresPermissions("endevice:save")
	public R save(@RequestBody EnDevice enDevice){
		enDeviceService.save(enDevice);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改设备信息表")
	@RequestMapping("/update")
	@RequiresPermissions("endevice:update")
	public R update(@RequestBody EnDevice enDevice){
		enDeviceService.update(enDevice);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用设备信息表")
    @RequestMapping("/enable")
    @RequiresPermissions("endevice:update")
    public R enable(@RequestBody String[] ids){
        String stateValue= StateEnum.ENABLE.getCode();
		enDeviceService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用设备信息表")
    @RequestMapping("/limit")
    @RequiresPermissions("endevice:update")
    public R limit(@RequestBody String[] ids){
        String stateValue= StateEnum.LIMIT.getCode();
		enDeviceService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除设备信息表")
	@RequestMapping("/delete")
	@RequiresPermissions("endevice:delete")
	public R delete(@RequestBody String[] ids){
		enDeviceService.deleteBatch(ids);
		return R.ok();
	}

}
