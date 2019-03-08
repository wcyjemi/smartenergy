package xin.cymall.controller;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.log.SysLog;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;
import xin.cymall.entity.EnCompany;
import xin.cymall.service.EnCompanyService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 企业信息前端控制器 controller
 * @author wcy
 * @date 2019年3月1日15:13:43
 */
@Controller
@RequestMapping(value = "/encompany")
public class EnCompanyController extends AbstractController{
    @Autowired
    private EnCompanyService enCompanyService;

    /**
     * 企业信息列表
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("energy:company:list")
    public String list(){
        return "encompany/list";
    }

    /**
     * 所有企业列表
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("energy:company:list")
    public R listData(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<EnCompany> enCompanyList = enCompanyService.queryList(query);
        int total = enCompanyService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(enCompanyList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 跳转到添加页面
     */
    @RequestMapping("/add")
    public String add(){
        return "encompany/add";
    }

    /**
     * 保存企业信息
     * @param enCompany
     * @return
     */
    @ResponseBody
    @RequestMapping("/save")
    @SysLog("新增企业信息")
    @RequiresPermissions("energy:company:save")
    public R save(@RequestBody EnCompany enCompany){
        //校验企业名称不能重复
        List<EnCompany> enCompanyList = enCompanyService.queryByName(enCompany);
        if (enCompanyList != null && enCompanyList.size()>0){
            return R.error("企业名称已存在");
        }
        //保存企业信息
        try{
            enCompanyService.save(enCompany);
        }catch (Exception e){
            logger.error("保存企业信息出错",e.toString());
            return R.error("保存企业信息出错");
        }
        return R.ok("保存成功!");
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id") Integer id){
        EnCompany enCompany = enCompanyService.queryObject(id);
        model.addAttribute("model",enCompany);
        return "encompany/edit";
    }

    /**
     * 保存企业信息
     * @param enCompany
     * @return
     */
    @ResponseBody
    @SysLog("修改企业信息")
    @RequestMapping("/update")
    @RequiresPermissions("energy:company:update")
    public R update(@RequestBody EnCompany enCompany){
        //校验企业名称不能重复
        List<EnCompany> enCompanyList = enCompanyService.queryByName(enCompany);
        if (enCompanyList != null && enCompanyList.size()>0){
            return R.error("企业名称已存在");
        }
        //保存企业信息
        try{
            enCompanyService.update(enCompany);
        }catch (Exception e){
            logger.error("保存企业信息出错",e.toString());
            return R.error("保存企业信息出错");
        }
        return R.ok("保存成功!");
    }

    /**
     * 删除企业信息
     * @param ids
     * @return
     */
    @ResponseBody
    @SysLog("删除企业信息")
    @RequestMapping("/delete")
    @RequiresPermissions("energy:company:delete")
    public R delete(@RequestBody Integer[] ids){
        try{
            enCompanyService.deleteBatch(ids);
        }catch (Exception e){
            logger.error("删除企业信息",e.toString());
            return R.error("删除企业信息失败");
        }
        return R.ok();
    }

    /**
     * 跳转到申请序列号页面
     * @return
     */
    @RequestMapping("/toApplySeri/{id}")
    public String toApplySeri(Model model,@PathVariable("id") Integer id){
        EnCompany enCompany = enCompanyService.queryObject(id);
        model.addAttribute("model",enCompany);
        return "encompany/apply";
    }

    @ResponseBody
    @SysLog("生成企业序列号")
    @RequestMapping("/generateSeri")
    @RequiresPermissions("energy:company:seri")
    public R generateSeri(@RequestBody EnCompany enCompany){
        try {
            enCompanyService.updateCompanyKey(enCompany);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("生成KEY失败",e.toString());
            return R.error("生成KEY失败");
        }
        return R.ok("生成KEY成功");
    }



}
