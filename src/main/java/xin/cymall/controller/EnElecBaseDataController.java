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

import xin.cymall.entity.EnElecBaseData;
import xin.cymall.service.EnElecBaseDataService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 电能实时数据
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-27 00:41:08
 */
@Controller
@RequestMapping("enelecbasedata")
public class EnElecBaseDataController {
	@Autowired
	private EnElecBaseDataService enElecBaseDataService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("enelecbasedata:list")
    public String list() {
        return "enelecbasedata/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("enelecbasedata:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EnElecBaseData> enElecBaseDataList = enElecBaseDataService.queryList(query);
		int total = enElecBaseDataService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(enElecBaseDataList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("enelecbasedata:save")
    public String add(){
        return "enelecbasedata/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("enelecbasedata:update")
    public String edit(Model model, @PathVariable("id") String id){
		EnElecBaseData enElecBaseData = enElecBaseDataService.queryObject(id);
        model.addAttribute("model",enElecBaseData);
        return "enelecbasedata/edit";
    }

    /**
     * 跳转到详情页面
     */
    @RequestMapping("detail/{id}")
    @RequiresPermissions("encollector:info")
    public String detail(Model model, @PathVariable("id") String id){
        EnElecBaseData enElecBaseData = enElecBaseDataService.queryObject(id);
        model.addAttribute("model",enElecBaseData);
        return "encollector/info";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("enelecbasedata:info")
    public R info(@PathVariable("id") String id){
        EnElecBaseData enElecBaseData = enElecBaseDataService.queryObject(id);
        return R.ok().put("enElecBaseData", enElecBaseData);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存电能实时数据")
	@RequestMapping("/save")
	@RequiresPermissions("enelecbasedata:save")
	public R save(@RequestBody EnElecBaseData enElecBaseData){
		enElecBaseDataService.save(enElecBaseData);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改电能实时数据")
	@RequestMapping("/update")
	@RequiresPermissions("enelecbasedata:update")
	public R update(@RequestBody EnElecBaseData enElecBaseData){
		enElecBaseDataService.update(enElecBaseData);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用电能实时数据")
    @RequestMapping("/enable")
    @RequiresPermissions("enelecbasedata:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		enElecBaseDataService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用电能实时数据")
    @RequestMapping("/limit")
    @RequiresPermissions("enelecbasedata:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		enElecBaseDataService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除电能实时数据")
	@RequestMapping("/delete")
	@RequiresPermissions("enelecbasedata:delete")
	public R delete(@RequestBody String[] ids){
		enElecBaseDataService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
