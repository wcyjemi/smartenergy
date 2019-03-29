package xin.cymall.service;

import xin.cymall.entity.EnConcentrator;

import java.util.List;
import java.util.Map;

/**
 * 集中器信息表
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-03-28 14:44:28
 */
public interface EnConcentratorService {
	
	EnConcentrator queryObject(String id);
	
	List<EnConcentrator> queryList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EnConcentrator enConcentrator);
	
	void update(EnConcentrator enConcentrator);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}
