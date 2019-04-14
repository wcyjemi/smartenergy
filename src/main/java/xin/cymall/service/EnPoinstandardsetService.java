package xin.cymall.service;

import xin.cymall.entity.EnPoinstandardset;

import java.util.List;
import java.util.Map;

/**
 * 监测点数据项标准值设置
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-02 15:59:22
 */
public interface EnPoinstandardsetService {
	
	EnPoinstandardset queryObject(String id);
	
	List<EnPoinstandardset> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);

	List<EnPoinstandardset> queryByPointId(String pointId);
	
	void save(EnPoinstandardset enPoinstandardset);
	
	void update(EnPoinstandardset enPoinstandardset);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}
