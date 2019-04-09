package xin.cymall.service;

import xin.cymall.common.utils.EnumBean;
import xin.cymall.entity.EnDevice;

import java.util.List;
import java.util.Map;

/**
 * 设备信息表
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-03 15:11:53
 */
public interface EnDeviceService {

	EnDevice queryObject(String id);
	
	List<EnDevice> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EnDevice enDevice);
	
	void update(EnDevice enDevice);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);

	List<EnumBean> queryAllList();
}
