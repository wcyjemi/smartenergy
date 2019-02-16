package xin.cymall.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.cymall.common.utils.DateUtil;
import xin.cymall.common.utils.EnumBean;
import xin.cymall.common.utils.R;
import xin.cymall.entity.AppBaseInfo;
import xin.cymall.service.AppBaseInfoService;
import xin.cymall.service.AppStaticsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据统计
 * @author wcy
 * @date 2019年1月10日09:58:54
 */
@Controller
@RequestMapping("statics")
public class AppStaticsController extends AbstractController{

    @Autowired
    private AppBaseInfoService appBaseInfoService;
    @Autowired
    private AppStaticsService appStaticsService;

    /**
     * 应用日更新量
     * @return
     */
    @ResponseBody
    @RequestMapping("/stcUpdCountByDay")
    public R stcUpdCountByDay(){
        //获取所有应用
        List<AppBaseInfo> appBaseInfoList = appBaseInfoService.queryList(new HashMap<String, Object>());
        //legend data
        ArrayList<String> legendData = new ArrayList<>();
        //xAxis Data
        ArrayList<String> xAxisData = DateUtil.getPreAnyDayDate(7);
        //series Array
        JSONArray seriesArray = new JSONArray();
        for (AppBaseInfo appBaseInfo:appBaseInfoList){
            legendData.add(appBaseInfo.getAppName());

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",appBaseInfo.getAppName());
            jsonObject.put("type","line");
            jsonObject.put("stack","日更新量");
            jsonObject.put("smooth",true);

            ArrayList<String> data = new ArrayList<>();

            Map<String,Object> param = new HashMap<>();
            param.put("appId",appBaseInfo.getId());
            param.put("st",xAxisData.get(0));
            param.put("et",xAxisData.get(xAxisData.size()-1));
            List<EnumBean> enumBeanList = appStaticsService.appDayUpdCount(param);
            if (enumBeanList != null && enumBeanList.size()>0){
                for (String str : xAxisData){
                    boolean isHas = false;
                    for (EnumBean enumBean : enumBeanList){
                        if (str.equals(enumBean.getCode())){
                            data.add(enumBean.getValue());
                            isHas = true;
                            break;
                        }
                    }
                    if (!isHas){
                        data.add("-");
                    }
                }
            }
            jsonObject.put("data",data);
            seriesArray.add(jsonObject);
        }

        JSONObject res = new JSONObject();
        res.put("legendData",legendData);
        res.put("xAxisData",xAxisData);
        res.put("seriesArray",seriesArray);

        return R.ok().put("resultData",res);
    }

    /**
     * 应用更新占比
     * @return
     */
    @ResponseBody
    @RequestMapping("/appZbPie")
    public R appZbPie(){
        List<EnumBean> enumBeanList = appStaticsService.appZbPie();
        ArrayList<String> lends = new ArrayList<>();
        JSONArray res = new JSONArray();
        if (enumBeanList != null && enumBeanList.size()>0){
            for (EnumBean enumBean : enumBeanList){
                JSONObject jsonObject = new JSONObject();
                lends.add(enumBean.getCode());
                jsonObject.put("name",enumBean.getCode());
                jsonObject.put("value",enumBean.getValue());
                res.add(jsonObject);
            }
        }
        return R.ok().put("lends",lends).put("data",res);
    }

}
