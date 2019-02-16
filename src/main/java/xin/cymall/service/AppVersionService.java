package xin.cymall.service;

import xin.cymall.entity.AppBaseInfo;
import xin.cymall.entity.AppVersion;

import java.util.List;
import java.util.Map;

/**
 * 
 * 应用基本信息 service
 * @author wcy
 * @date 2019年1月3日14:27:48
 */
public interface AppVersionService {

	List<AppVersion> queryList(Map<String, Object> map);

	AppVersion queryObject(Integer id);

	AppVersion queryLastAppVer(AppVersion appVersion);

	List<AppVersion> findByVerify(AppVersion appVersion);

	int queryTotal(Map<String, Object> map);

	void save(AppVersion appVersion) throws Exception;

	void update(AppVersion appVersion);

	void updateBatch(Integer[] ids, String stateValue);
	void updDownCount(Long id);

	void deleteBatch(Integer[] ids);

}
