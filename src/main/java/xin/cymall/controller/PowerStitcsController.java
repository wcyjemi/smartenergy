package xin.cymall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.cymall.entity.EnCollectionPoint;
import xin.cymall.entity.EnCompany;
import xin.cymall.entity.SysUser;
import xin.cymall.service.EnCollectionPointService;
import xin.cymall.service.EnCompanyService;
import xin.cymall.service.SysUserCompanyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 能源分析
 *
 * @author wcy
 * @email 228112142@qq.com
 * @date 2019-03-19 11:10:52
 */
@Controller
@RequestMapping("/encollectionpoint")
public class PowerStitcsController extends AbstractController{

    @Autowired
    private EnCompanyService enCompanyService;

    @Autowired
    private SysUserCompanyService sysUserCompanyService;

    @Autowired
    private EnCollectionPointService enCollectionPointService;

    @RequestMapping("/getVisTreeViewData")
    @ResponseBody
    public List<Map<String, Object>> getVisTreeViewData(Map<String, Object> param){
        List<Map<String, Object>> maps = new ArrayList<>();
        //获取当前登录用户
        SysUser loginUser = getUser();
        //查询企业
        List<String> companyIds = sysUserCompanyService.queryCompanyIdList(loginUser.getUserId());
        if (companyIds != null && companyIds.size()>0){
            param.put("companyId",companyIds.get(0));
        }
        List<EnCompany> enCompanyList = enCompanyService.queryList(param);
        if (enCompanyList != null && enCompanyList.size()>0){
            maps = enCollectionPointService.getPointTreeView(enCompanyList);
        }
        return maps;
    }

    @RequestMapping("/powerVis")
    public String powerVis(){
        return "powrvis/powerstatic";
    }

}
