package xin.cymall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.enumresource.TopMenuEnum;
import xin.cymall.common.log.SysLog;
import xin.cymall.common.utils.*;
import xin.cymall.entity.EnCompany;
import xin.cymall.entity.EnMonitorUnit;
import xin.cymall.service.EnCompanyService;
import xin.cymall.service.EnMonitorUnitService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 监测单位前端控制器 controller
 * @author wcy
 * @date 2019年3月1日15:13:43
 */
@Controller
@RequestMapping(value = "/enmonitorunit")
public class EnMonitorUnitController extends AbstractController{
    @Autowired
    private EnMonitorUnitService enMonitorUnitService;

    /**
     * 监测单位列表
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("energy:monitorunit:list")
    public String list(){
        return "monitorunit/list";
    }

    /**
     * 所有监测单位列表
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("energy:monitorunit:list")
    public R listData(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<EnMonitorUnit> enCompanyList = enMonitorUnitService.queryList(query);
        int total = enMonitorUnitService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(enCompanyList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 获取树形table数据
     * @param params
     * @return
     */
    @ResponseBody
    @RequestMapping("/treeTableData")
    public JSONArray treeTableData(@RequestParam Map<String,Object> params){
        List<TreeTableBean> treeTableBeans = enMonitorUnitService.queryTreeTable(params);
        return JSONArray.parseArray(JSON.toJSONString(treeTableBeans));
    }

    /**
     * 跳转到选择企业页面
     * @return
     */
    @RequestMapping("/toSelectCompany")
    public String toSelectCompany(){
        return "monitorunit/selectCompany";
    }

    /**
     * 选择监测单位
     * @param companyId
     * @return
     */
    @ResponseBody
    @RequestMapping("/select")
    public R selectMonitorUnit(@RequestParam String companyId){

        if (companyId == null){
            return R.error("请选择企业！");
        }

        //查询列表数据
        List<EnMonitorUnit> enMonitorUnits = enMonitorUnitService.queryListByCompId(companyId);

        //添加顶级菜单
        EnMonitorUnit root = new EnMonitorUnit();
        root.setId(TopMenuEnum.TopMonitorUnit.getCode());
        root.setMonitorUnitName(TopMenuEnum.TopMonitorUnit.getDesc());
        root.setParentId("-1");
        enMonitorUnits.add(root);
        List<ZtreeBean> ztreeBeans = new ArrayList<>();
        for (EnMonitorUnit enMonitorUnit : enMonitorUnits) {
            ZtreeBean tree = new ZtreeBean();
            tree.setId(enMonitorUnit.getId() + "");
            tree.setpId(enMonitorUnit.getParentId() + "");
            tree.setName(enMonitorUnit.getMonitorUnitName());
            tree.setOpen("true");
            tree.setChkDisabled("false");
            ztreeBeans.add(tree);
        }

        return R.ok().put("data", ztreeBeans);
    }

    /**
     * 跳转到添加页面
     */
    @RequestMapping("/add")
    public String add(@RequestParam String companyId,Model model){
        EnMonitorUnit enMonitorUnit = new EnMonitorUnit();
        enMonitorUnit.setCompanyId(companyId);
        model.addAttribute("model",enMonitorUnit);
        return "monitorunit/add";
    }

    /**
     * 保存监测单位信息
     * @param enMonitorUnit
     * @return
     */
    @ResponseBody
    @RequestMapping("/save")
    @SysLog("新增监测单位信息")
    @RequiresPermissions("energy:monitorunit:save")
    public R save(@RequestBody EnMonitorUnit enMonitorUnit){
        //保存监测单位信息
        try{
            if ("0".equals(enMonitorUnit.getParentId())){
                enMonitorUnit.setParentIds("0");
                enMonitorUnit.setLevel(1);
            }else {
                EnMonitorUnit parentEm = enMonitorUnitService.queryObject(enMonitorUnit.getParentId());
                enMonitorUnit.setParentIds(parentEm.getParentIds()+","+parentEm.getId());
                String[] parentIds = parentEm.getParentIds().split(",");
                enMonitorUnit.setLevel(parentIds.length+1);
            }
            enMonitorUnitService.save(enMonitorUnit);
        }catch (Exception e){
            logger.error("保存监测单位出错",e.toString());
            return R.error("保存监测单位信息出错");
        }
        return R.ok("保存成功!");
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id") String id){
        EnMonitorUnit enMonitorUnit = enMonitorUnitService.queryObject(id);
        model.addAttribute("model",enMonitorUnit);
        return "monitorunit/edit";
    }

    /**
     * 修改监测单位信息
     * @param enMonitorUnit
     * @return
     */
    @ResponseBody
    @SysLog("修改监测单位信息")
    @RequestMapping("/update")
    @RequiresPermissions("energy:monitorunit:update")
    public R update(@RequestBody EnMonitorUnit enMonitorUnit){
        //保存企业信息
        try{
            if ("0".equals(enMonitorUnit.getParentId())){
                enMonitorUnit.setParentIds("0");
                enMonitorUnit.setLevel(1);
            }else {
                EnMonitorUnit parentEm = enMonitorUnitService.queryObject(enMonitorUnit.getParentId());
                enMonitorUnit.setParentIds(parentEm.getParentIds()+","+parentEm.getId());
                String[] parentIds = parentEm.getParentIds().split(",");
                enMonitorUnit.setLevel(parentIds.length+1);
            }
            enMonitorUnitService.update(enMonitorUnit);
        }catch (Exception e){
            logger.error("保存监测单位信息出错",e.toString());
            return R.error("保存监测单位信息出错");
        }
        return R.ok("保存成功!");
    }

    /**
     * 删除监测单位信息
     * @param ids
     * @return
     */
    @ResponseBody
    @SysLog("删除监测单位信息")
    @RequestMapping("/delete")
    @RequiresPermissions("energy:monitorunit:delete")
    public R delete(@RequestBody String[] ids){
        try{
            enMonitorUnitService.deleteBatch(ids);
        }catch (Exception e){
            logger.error("删除监测单位信息",e.toString());
            return R.error("删除监测单位信息失败");
        }
        return R.ok();
    }

}
