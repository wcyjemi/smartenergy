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

import xin.cymall.entity.EnCollector;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;
import xin.cymall.service.EnCollectorService;


/**
 * 采集器信息表
 *
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-03-25 20:59:22
 */
@Controller
@RequestMapping("encollector")
public class EnCollectorController {
    @Autowired
    private EnCollectorService enCollectorService;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("encollector:list")
    public String list() {
        return "encollector/list";
    }

    /**
     * 列表数据
     */
    @ResponseBody
    @RequestMapping("/listData")
    @RequiresPermissions("encollector:list")
    public R listData(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EnCollector> enCollectorList = enCollectorService.queryList(query);
        int total = enCollectorService.getCount(query);

        PageUtils pageUtil = new PageUtils(enCollectorList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("encollector:save")
    public String add() {
        return "encollector/add";
    }

    /**
     * 跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("encollector:update")
    public String edit(Model model, @PathVariable("id") String id) {
        EnCollector enCollector = enCollectorService.queryObject(id);
        model.addAttribute("model", enCollector);
        return "encollector/edit";
    }


    /**
     * 信息
     */

    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("encollector:info")
    public R info(@PathVariable("id") String id){
        EnCollector enCollector = enCollectorService.queryObject(id);
        return R.ok().put("enCollector", enCollector);
    }



    /*
     */
/**
     * 跳转到详情页面
     */

    @RequestMapping("details/{id}")
    @RequiresPermissions("encollector:info")
    public String details(Model model, @PathVariable("id") String id){
        EnCollector enCollector = enCollectorService.queryObject(id);
        model.addAttribute("model",enCollector);
        return "encollector/info";
    }


    /**
     * 保存
     */
    @ResponseBody
    @SysLog("保存采集器信息表")
    @RequestMapping("/save")
    @RequiresPermissions("encollector:save")
    public R save(@RequestBody EnCollector enCollector) {

        enCollectorService.save(enCollector);

        return R.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @SysLog("修改采集器信息表")
    @RequestMapping("/update")
    @RequiresPermissions("encollector:update")
    public R update(@RequestBody EnCollector enCollector) {
        enCollectorService.update(enCollector);

        return R.ok();
    }

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用采集器信息表")
    @RequestMapping("/enable")
    @RequiresPermissions("encollector:update")
    public R enable(@RequestBody String[] ids) {
        String stateValue = StateEnum.ENABLE.getCode();
        enCollectorService.updateState(ids, stateValue);
        return R.ok();
    }

    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用采集器信息表")
    @RequestMapping("/limit")
    @RequiresPermissions("encollector:update")
    public R limit(@RequestBody String[] ids) {
        String stateValue = StateEnum.LIMIT.getCode();
        enCollectorService.updateState(ids, stateValue);
        return R.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @SysLog("删除采集器信息表")
    @RequestMapping("/delete")
    @RequiresPermissions("encollector:delete")
    public R delete(@RequestBody String[] ids) {
        enCollectorService.deleteBatch(ids);

        return R.ok();
    }

}
