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
import xin.cymall.vo.EnRealDataTableVo;

import java.math.BigDecimal;
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
    public String realTimeVis(String pointIds,String compareTime, Model model){
//        String pointIds = requestMap.get("pointIds") == null?"":requestMap.get("pointIds").toString();
//        String compareTime = requestMap.get("compareTime") == null?"" : requestMap.get("compareTime").toString();
        model.addAttribute("pointIds",pointIds);
        model.addAttribute("compareTime",compareTime==null?"":compareTime);
        return "powrvis/realtimevis";
    }

    /**
     * 负荷实时数据
     * @param pointIds
     * @param compareTime
     * @return
     */
    @ResponseBody
    @RequestMapping("/powAtRealTime")
    public R powAtRealTime(String pointIds,String compareTime){
        pointIds = pointIds == null ? "" : pointIds;
        String beginTime;
        String endTime = "";
        compareTime = compareTime == null?"" : compareTime;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        beginTime = DateUtil.getDayTimeSt(compareTime);
        endTime = DateUtil.getDayTimeEd(compareTime);
        if (StringUtil.isBlank(compareTime)){
            compareTime = dateFormat.format(new Date());
        }
        Map<String,Object> param = new HashMap<>();
        param.put("beginTime",beginTime);
        param.put("endTime",endTime);
        param.put("compareTime",compareTime);
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
        R r = R.ok();
        r.put("legendData",legendData);
        r.put("xAxisData",xAxisData);
        r.put("seriesArray",seriesArray);
        return r;
    }
    /**
     * 负荷实时数据
     * @param pointIds
     * @param compareTime
     * @return
     */
    @ResponseBody
    @RequestMapping("/powAtTableData")
    public R powAtTableData(String pointIds,String compareTime){
        pointIds = pointIds == null ? "" : pointIds;
        String beginTime;
        String endTime = "";
        compareTime = compareTime == null?"" : compareTime;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        beginTime = DateUtil.getDayTimeSt(compareTime);
        endTime = DateUtil.getDayTimeEd(compareTime);
        if (StringUtil.isBlank(compareTime)){
            compareTime = dateFormat.format(new Date());
        }
        Map<String,Object> param = new HashMap<>();
        param.put("beginTime",beginTime);
        param.put("endTime",endTime);
        param.put("compareTime",compareTime);
        String[] pointIdArr = pointIds.split("_");
        List<EnRealDataTableVo> enRealDataTableVos = new ArrayList<>();
        for (int i=0; i < pointIdArr.length; i++){
            if (!StringUtil.isBlank(pointIdArr[i])){
                EnCollectionPoint enCollectionPoint = enCollectionPointService.queryObject(pointIdArr[i]);
                param.put("pointId",enCollectionPoint.getId());
                //获取平均负荷
                param.put("sortColumn","pow_at");
                Float powAtAvg = enElecBaseDataService.queryAnyCclumnAvg(param);
                //获取最大负荷
                param.put("sort","desc");
                EnElecBaseData enElecBaseDataMax = enElecBaseDataService.queryAnyCclumnSort(param);
                //获取最小负荷
                param.put("sort","asc");
                EnElecBaseData enElecBaseDataMin = enElecBaseDataService.queryAnyCclumnSort(param);
                //负荷率
                BigDecimal powAtPerc = new BigDecimal(powAtAvg).divide(enElecBaseDataMax.getPowAt(),2,BigDecimal.ROUND_HALF_UP);
                EnRealDataTableVo realDataTableVo = new EnRealDataTableVo();
                realDataTableVo.setPointName(enCollectionPoint.getCollectionPointName());
                realDataTableVo.setMaxValue(enElecBaseDataMax.getPowAt());
                realDataTableVo.setMaxDataTime(dateFormat.format(enElecBaseDataMax.getDataTime()));
                realDataTableVo.setMinValue(enElecBaseDataMin.getPowAt());
                realDataTableVo.setMinDataTime(dateFormat.format(enElecBaseDataMin.getDataTime()));
                realDataTableVo.setAvgVal(new BigDecimal(powAtAvg).setScale(2,BigDecimal.ROUND_HALF_UP));
                realDataTableVo.setDataPer(powAtPerc);
                enRealDataTableVos.add(realDataTableVo);
            }
        }
        return R.ok().put("enRealDataTableVos",enRealDataTableVos);
    }

    @RequestMapping("/realTimeElec")
    public String realTimeElec(String pointIds,String compareTime, Model model){
//        String pointIds = requestMap.get("pointIds") == null?"":requestMap.get("pointIds").toString();
//        String compareTime = requestMap.get("compareTime") == null?"" : requestMap.get("compareTime").toString();
        model.addAttribute("pointIds",pointIds);
        model.addAttribute("compareTime",compareTime==null?"":compareTime);
        return "powrvis/realtimeelec";
    }

    /**
     * 电量实时图表数据
     * @param pointIds
     * @param compareTime
     * @return
     */
    @ResponseBody
    @RequestMapping("/elecRealTime")
    public R elecRealTime(String pointIds,String compareTime){
        pointIds = pointIds == null ? "" : pointIds;
        String beginTime;
        String endTime = "";
        compareTime = compareTime == null?"" : compareTime;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        beginTime = DateUtil.getDayTimeSt(compareTime);
        endTime = DateUtil.getDayTimeEd(compareTime);
        if (StringUtil.isBlank(compareTime)){
            compareTime = dateFormat.format(new Date());
        }
        Map<String,Object> param = new HashMap<>();
        param.put("beginTime",beginTime);
        param.put("endTime",endTime);
        param.put("compareTime",compareTime);
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
                seriesJsonObj.put("type","bar");
                seriesJsonObj.put("stack","电量");
                seriesJsonObj.put("smooth",true);
                seriesJsonObj.put("data",getElecData(enElecBaseDataService.getRealData(param),xAxisData));
                seriesArray.add(seriesJsonObj);
            }
        }
        R r = R.ok();
        r.put("legendData",legendData);
        r.put("xAxisData",xAxisData);
        r.put("seriesArray",seriesArray);
        return r;
    }

    /**
     * 负荷实时数据
     * @param pointIds
     * @param compareTime
     * @return
     */
    @ResponseBody
    @RequestMapping("/elecTableData")
    public R elecTableData(String pointIds,String compareTime){
        pointIds = pointIds == null ? "" : pointIds;
        String beginTime;
        String endTime = "";
        compareTime = compareTime == null?"" : compareTime;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        beginTime = DateUtil.getDayTimeSt(compareTime);
        endTime = DateUtil.getDayTimeEd(compareTime);
        if (StringUtil.isBlank(compareTime)){
            compareTime = dateFormat.format(new Date());
        }
        Map<String,Object> param = new HashMap<>();
        param.put("beginTime",beginTime);
        param.put("endTime",endTime);
        param.put("compareTime",compareTime);
        String[] pointIdArr = pointIds.split("_");
        List<EnElecBaseData> elecBaseDataList = new ArrayList<>();
        for (int i=0; i < pointIdArr.length; i++){
            if (!StringUtil.isBlank(pointIdArr[i])){
                EnCollectionPoint enCollectionPoint = enCollectionPointService.queryObject(pointIdArr[i]);
                param.put("pointId",enCollectionPoint.getId());
                List<EnElecBaseData> enElecBaseDatas = enElecBaseDataService.getRealData(param);
                elecBaseDataList.addAll(enElecBaseDatas);
            }
        }
        return R.ok().put("elecBaseDataList",elecBaseDataList);
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
    public ArrayList<String> getElecData(List<EnElecBaseData> enElecBaseData,ArrayList<String> xAxisData){
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
                        dataArr.add(String.valueOf(enElecBaseData1.getEleFa()));
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
