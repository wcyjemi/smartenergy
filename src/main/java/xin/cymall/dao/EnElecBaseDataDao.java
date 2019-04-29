package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.EnElecBaseData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 电能实时数据
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-27 00:41:08
 */
@Mapper
@Repository
public interface EnElecBaseDataDao extends BaseDao<EnElecBaseData> {
	ArrayList<String> getXtimeArr(Map<String,Object> param);

    ArrayList<String> getRealPowAtData(Map<String,Object> param);

    List<EnElecBaseData> getRealData(Map<String,Object> param);

}
