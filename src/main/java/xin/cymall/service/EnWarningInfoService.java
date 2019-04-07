package xin.cymall.service;

import xin.cymall.entity.EnWarningInfo;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-02 15:53:34
 */
public interface EnWarningInfoService {
	
	EnWarningInfo queryObject(String id);
	
	List<EnWarningInfo> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EnWarningInfo enWarningInfo);
	
}
