package xin.cymall.service;

import xin.cymall.entity.EnInstructions;

import java.util.List;
import java.util.Map;

/**
 * 数据项信息
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-03 10:42:59
 */
public interface EnInstructionsService {
	
	EnInstructions queryObject(String id);
	
	List<EnInstructions> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EnInstructions enInstructions);
	
	void update(EnInstructions enInstructions);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);

	List<EnInstructions> queryListAll(Map<String,Object> map);
}
