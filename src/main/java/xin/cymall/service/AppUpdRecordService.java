package xin.cymall.service;

import xin.cymall.entity.AppUpdRecord;
import xin.cymall.entity.AppVersion;

import java.util.List;
import java.util.Map;

/**
 * 
 * 应用基本信息 service
 * @author wcy
 * @date 2019年1月3日14:27:48
 */
public interface AppUpdRecordService {

	List<AppUpdRecord> queryList(Map<String, Object> map);

	AppUpdRecord queryObject(Integer id);

	int queryTotal(Map<String, Object> map);

	void save(AppUpdRecord appUpdRecord);

	void update(AppUpdRecord appUpdRecord);

	void deleteBatch(Integer[] ids);

}
