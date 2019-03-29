package xin.cymall.service;

import xin.cymall.entity.EnCollector;

import java.util.List;
import java.util.Map;

/**
 * 采集器信息表
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-03-25 20:59:22
 */
public interface EnCollectorService {
	
	EnCollector queryObject(String id);
	
	List<EnCollector> queryList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(EnCollector enCollector);
	
	void update(EnCollector enCollector);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}
