package xin.cymall.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import xin.cymall.common.enumresource.StateEnum;
import xin.cymall.common.log.SysLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import xin.cymall.entity.EnCompanyVisit;
import xin.cymall.service.EnCompanyVisitService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 企业回访记录信息表
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-03-29 11:11:07
 */
@Controller
@RequestMapping("encompanyvisit")
public class EnCompanyVisitController {
	@Autowired
	private EnCompanyVisitService enCompanyVisitService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list/{companyId}")
    public String list(Model model,@PathVariable("companyId") Integer companyId) {
        model.addAttribute("companyId",companyId);
        return "encompanyvisit/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EnCompanyVisit> enCompanyVisitList = enCompanyVisitService.queryList(query);
		int total = enCompanyVisitService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(enCompanyVisitList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    public String add(Model model, @Param("companyId") String companyId){
        EnCompanyVisit enCompanyVisit = new EnCompanyVisit();
        enCompanyVisit.setCompanyId(companyId);
        model.addAttribute("model", enCompanyVisit);
        return "encompanyvisit/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id") String id){
		EnCompanyVisit enCompanyVisit = enCompanyVisitService.queryObject(id);
        model.addAttribute("model",enCompanyVisit);
        return "encompanyvisit/edit";
    }

    /**
     * 跳转到详情页面
     */
    @RequestMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id") String id){
        EnCompanyVisit enCompanyVisit = enCompanyVisitService.queryObject(id);
        model.addAttribute("model",enCompanyVisit);
        return "encollector/info";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        EnCompanyVisit enCompanyVisit = enCompanyVisitService.queryObject(id);
        return R.ok().put("enCompanyVisit", enCompanyVisit);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存企业回访记录信息表")
	@RequestMapping("/save")
	public R save(@RequestBody EnCompanyVisit enCompanyVisit){
		enCompanyVisitService.save(enCompanyVisit);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改企业回访记录信息表")
	@RequestMapping("/update")
	public R update(@RequestBody EnCompanyVisit enCompanyVisit){
		enCompanyVisitService.update(enCompanyVisit);
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用企业回访记录信息表")
    @RequestMapping("/enable")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		enCompanyVisitService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用企业回访记录信息表")
    @RequestMapping("/limit")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		enCompanyVisitService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除企业回访记录信息表")
	@RequestMapping("/delete")
	public R delete(@RequestBody String[] ids){
		enCompanyVisitService.deleteBatch(ids);
		return R.ok();
	}
	
}
