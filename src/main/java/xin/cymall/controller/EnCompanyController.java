package xin.cymall.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;
import xin.cymall.entity.EnCompany;
import xin.cymall.service.EnCompanyService;

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
     * 所有用户列表
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
}
