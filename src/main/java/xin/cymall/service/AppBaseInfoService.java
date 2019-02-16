package xin.cymall.service;

import xin.cymall.entity.AppBaseInfo;

import java.util.List;
import java.util.Map;

/**
 * 
 * 应用基本信息 service
 * @author wcy
 * @date 2019年1月3日14:27:48
 */
public interface AppBaseInfoService {
	
	List<AppBaseInfo> queryList(Map<String, Object> map);
	
	AppBaseInfo queryObject(Integer id);
	
	List<AppBaseInfo> findByVerify(AppBaseInfo appBaseInfo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppBaseInfo appBaseInfo);
	
	void update(AppBaseInfo appBaseInfo);
	
	void updateBatch(Integer[] ids,String stateValue);
	
	void deleteBatch(Integer[] ids);

}
