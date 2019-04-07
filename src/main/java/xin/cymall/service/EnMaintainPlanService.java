package xin.cymall.service;

import xin.cymall.entity.EnMaintainPlan;

import java.util.List;
import java.util.Map;

/**
 * 设备维保计划
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-07 18:35:07
 */
public interface EnMaintainPlanService {
	
	EnMaintainPlan queryObject(String id);
	
	List<EnMaintainPlan> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EnMaintainPlan enMaintainPlan);
	
	void update(EnMaintainPlan enMaintainPlan);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}
