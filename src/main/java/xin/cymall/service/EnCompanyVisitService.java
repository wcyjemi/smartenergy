package xin.cymall.service;

import xin.cymall.entity.EnCompanyVisit;

import java.util.List;
import java.util.Map;

/**
 * 企业回访记录信息表
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-03-29 11:11:07
 */
public interface EnCompanyVisitService {
	
	EnCompanyVisit queryObject(String id);
	
	List<EnCompanyVisit> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EnCompanyVisit enCompanyVisit);
	
	void update(EnCompanyVisit enCompanyVisit);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}
