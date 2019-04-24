package xin.cymall.service;

import xin.cymall.entity.EnCollectionPoint;
import xin.cymall.vo.EnCollectionPointVo;

import java.util.List;
import java.util.Map;

/**
 * 采集点信息表
 * 
 * @author wcy
 * @email 228112142@qq.com
 * @date 2019-03-19 11:10:52
 */
public interface EnCollectionPointService {
	
	EnCollectionPoint queryObject(String id);
	EnCollectionPoint queryOneById(String id);

	List<EnCollectionPoint> queryList(Map<String, Object> map);

	List<EnCollectionPointVo> queryTreeData(Map<String,Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EnCollectionPoint enCollectionPoint);
	
	void update(EnCollectionPoint enCollectionPoint);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}
