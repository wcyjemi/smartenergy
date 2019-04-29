package xin.cymall.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.cymall.common.utils.DateUtil;
import xin.cymall.common.utils.R;
import xin.cymall.common.utils.StringUtil;
import xin.cymall.entity.EnCollectionPoint;
import xin.cymall.entity.EnCompany;
import xin.cymall.entity.EnElecBaseData;
import xin.cymall.entity.SysUser;
import xin.cymall.service.EnCollectionPointService;
import xin.cymall.service.EnCompanyService;
import xin.cymall.service.EnElecBaseDataService;
import xin.cymall.service.SysUserCompanyService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 能源分析
 *
 * @author wcy
 * @email 228112142@qq.com
 * @date 2019-03-19 11:10:52
 */
@Controller
@RequestMapping("/powerStitcs")
public class PowerStitcsController extends AbstractController{

    @Autowired
    private EnCompanyService enCompanyService;

    @Autowired
    private SysUserCompanyService sysUserCompanyService;

    @Autowired
    private EnCollectionPointService enCollectionPointService;

    @Autowired
    private EnElecBaseDataService enElecBaseDataService;

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

    @RequestMapping("/realTimeVis")
    public String realTimeVis(@RequestParam("pointIds") String pointIds, Model model){
        model.addAttribute("pointIds",pointIds);
        return "powrvis/realtimevis";
    }

    /**
     * 负荷实时数据
     * @param pointIds
     * @return
     */
    @ResponseBody
    @RequestMapping("/powAtRealTime")
    public R powAtRealTime(@RequestParam("pointIds") String pointIds,@RequestParam("beginTime") String beginTime,@RequestParam("endTime") String endTime){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtil.isBlank(beginTime)){
            beginTime = DateUtil.getDayTimeSt();
        }
        if (StringUtil.isBlank(endTime)){
            endTime = dateFormat.format(new Date());
        }
        Map<String,Object> param = new HashMap<>();
        param.put("beginTime",beginTime);
        param.put("endTime",endTime);
        String[] pointIdArr = pointIds.split("_");
        //legendData
        ArrayList<String> legendData = new ArrayList<>();
        //xAxisData
        ArrayList<String> xAxisData = DateUtil.getAllTimePoint(beginTime,endTime);

        //seriesArray
        JSONArray seriesArray = new JSONArray();
        for (int i=0; i < pointIdArr.length; i++){
            if (!StringUtil.isBlank(pointIdArr[i])){
                EnCollectionPoint enCollectionPoint = enCollectionPointService.queryObject(pointIdArr[i]);
                legendData.add(enCollectionPoint.getCollectionPointName());
                param.put("pointId",enCollectionPoint.getId());
                JSONObject seriesJsonObj = new JSONObject();
                seriesJsonObj.put("name",enCollectionPoint.getCollectionPointName());
                seriesJsonObj.put("type","line");
                seriesJsonObj.put("stack","负荷");
                seriesJsonObj.put("smooth",true);
                seriesJsonObj.put("data",getPowAt(enElecBaseDataService.getRealData(param),xAxisData));
                seriesArray.add(seriesJsonObj);
            }
        }
        return R.ok().put("legendData",legendData).put("xAxisData",xAxisData).put("seriesArray",seriesArray);
    }

    public ArrayList<String> getPowAt(List<EnElecBaseData> enElecBaseData,ArrayList<String> xAxisData){
        ArrayList<String> dataArr = new ArrayList<>();
        for (String str : xAxisData){
            if (enElecBaseData == null || enElecBaseData.size()<=0){
                dataArr.add("");
            }else {
                Boolean flag = false;
                for (EnElecBaseData enElecBaseData1 : enElecBaseData){
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date tempDate = null;
                    Date dataTime = null;
                    try {
                        tempDate = dateFormat.parse(str);
                        dataTime = dateFormat.parse(dateFormat.format(enElecBaseData1.getDataTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (DateUtil.compareDate(tempDate,dataTime)==0) {
                        flag = true;
                        dataArr.add(String.valueOf(enElecBaseData1.getPowAt()));
                        break;
                    }
                }
                if (!flag){
                    dataArr.add("");
                }
            }
        }
        return dataArr;
    }

}
