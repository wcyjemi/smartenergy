package xin.cymall.task;

import jxl.write.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xin.cymall.common.utils.R;
import xin.cymall.common.utils.RandomCharUtil;
import xin.cymall.entity.EnCollectionPoint;
import xin.cymall.entity.EnElecBaseData;
import xin.cymall.service.EnCollectionPointService;
import xin.cymall.service.EnElecBaseDataService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Configuration
@EnableScheduling
public class CreateDataScheduleTask {

    @Autowired
    private EnElecBaseDataService enElecBaseDataService;

    @Autowired
    private EnCollectionPointService enCollectionPointService;
    @Scheduled(cron = "0 0/5 * * * ? ")
    public void createData(){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取所有监测点
        Map<String,Object> map = new HashMap<>();
        List<EnCollectionPoint> enCollectionPointList = enCollectionPointService.queryList(map);
        if (enCollectionPointList != null && enCollectionPointList.size()>0){
            for (EnCollectionPoint enCollectionPoint : enCollectionPointList){
                EnElecBaseData enElecBaseData = new EnElecBaseData();
                enElecBaseData.setPointId(enCollectionPoint.getId());
                enElecBaseData.setDataTime(new Date());
                enElecBaseData.setEleFa(RandomCharUtil.rendEleDecimal());
                enElecBaseData.setEleFr(RandomCharUtil.rendEleDecimal());
                enElecBaseData.setEleRr(RandomCharUtil.rendEleDecimal());
                enElecBaseData.setEleRa(RandomCharUtil.rendEleDecimal());
                enElecBaseData.setPowAt(RandomCharUtil.rendPowDecimal());
                enElecBaseData.setPowAa(RandomCharUtil.rendPowDecimal());
                enElecBaseData.setPowAb(RandomCharUtil.rendPowDecimal());
                enElecBaseData.setPowAc(RandomCharUtil.rendPowDecimal());
                enElecBaseData.setPowRt(RandomCharUtil.rendPowDecimal());
                enElecBaseData.setPowRa(RandomCharUtil.rendPowDecimal());
                enElecBaseData.setPowRb(RandomCharUtil.rendPowDecimal());
                enElecBaseData.setPowRc(RandomCharUtil.rendPowDecimal());
                enElecBaseData.setPowfT(RandomCharUtil.rendPowFDecimal());
                enElecBaseData.setPowfA(RandomCharUtil.rendPowFDecimal());
                enElecBaseData.setPowfB(RandomCharUtil.rendPowFDecimal());
                enElecBaseData.setPowfC(RandomCharUtil.rendPowFDecimal());
                enElecBaseData.setVolA(RandomCharUtil.rendVolDecimal());
                enElecBaseData.setVolB(RandomCharUtil.rendVolDecimal());
                enElecBaseData.setVolC(RandomCharUtil.rendVolDecimal());
                enElecBaseData.setCurA(RandomCharUtil.rendCurDecimal());
                enElecBaseData.setCurB(RandomCharUtil.rendCurDecimal());
                enElecBaseData.setCurC(RandomCharUtil.rendCurDecimal());
                enElecBaseData.setVpaA(RandomCharUtil.rendXwjDecimal());
                enElecBaseData.setVpaB(RandomCharUtil.rendXwjDecimal());
                enElecBaseData.setVpaC(RandomCharUtil.rendXwjDecimal());
                enElecBaseData.setCpaA(RandomCharUtil.rendXwjDecimal());
                enElecBaseData.setCpaB(RandomCharUtil.rendXwjDecimal());
                enElecBaseData.setCpaC(RandomCharUtil.rendXwjDecimal());
                enElecBaseData.setXlTo(RandomCharUtil.rendXlDecimal());
                enElecBaseData.setXlTodt(new Date());
                enElecBaseData.setXlPi(RandomCharUtil.rendXlDecimal());
                enElecBaseData.setXlPidt(new Date());
                enElecBaseData.setXlPe(RandomCharUtil.rendXlDecimal());
                enElecBaseData.setXlPedt(new Date());
                enElecBaseData.setXlFl(RandomCharUtil.rendXlDecimal());
                enElecBaseData.setXlFldt(new Date());
                enElecBaseData.setXlVa(RandomCharUtil.rendXlDecimal());
                enElecBaseData.setXlVadt(new Date());
                enElecBaseData.setXlfrTo(RandomCharUtil.rendXlDecimal());
                enElecBaseData.setXlfrTodt(new Date());
                enElecBaseData.setXlfrPi(RandomCharUtil.rendXlDecimal());
                enElecBaseData.setXlfrPidt(new Date());
                enElecBaseData.setXlfrPe(RandomCharUtil.rendXlDecimal());
                enElecBaseData.setXlfrPedt(new Date());
                enElecBaseData.setXlfrFl(RandomCharUtil.rendXlDecimal());
                enElecBaseData.setXlfrFldt(new Date());
                enElecBaseData.setXlfrVa(RandomCharUtil.rendXlDecimal());
                enElecBaseData.setXlfrVadt(new Date());
                enElecBaseDataService.save(enElecBaseData);
            }
        }

        System.out.println("------------>>>" + new Date());

    }

}
