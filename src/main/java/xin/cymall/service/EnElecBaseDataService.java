package xin.cymall.service;

import xin.cymall.entity.EnElecBaseData;

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
public interface EnElecBaseDataService {
	
	EnElecBaseData queryObject(String id);
	
	List<EnElecBaseData> queryList(Map<String, Object> map);

	ArrayList<String> getXtimeArr(Map<String, Object> map);

	ArrayList<String> getRealPowAtData(Map<String, Object> map);

	List<EnElecBaseData> getRealData(Map<String,Object> map);

	int queryTotal(Map<String, Object> map);
	
	void save(EnElecBaseData enElecBaseData);
	
	void update(EnElecBaseData enElecBaseData);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}
