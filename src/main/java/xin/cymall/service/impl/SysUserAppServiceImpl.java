package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.cymall.dao.SysUserAppDao;
import xin.cymall.service.SysUserAppService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户与APP对应关系
 * 
 * @author wcy
 * @date 2019年1月3日17:55:06
 */
@Service("sysUserAppService")
public class SysUserAppServiceImpl implements SysUserAppService {
	@Autowired
	private SysUserAppDao sysUserAppDao;

	@Override
	public void saveOrUpdate(Long userId, List<Long> appIdList) {
//		if(appIdList==null||appIdList.size() == 0){
//			return ;
//		}
		//先删除用户与APP关系
		sysUserAppDao.delete(userId);
		if (appIdList.size()>0) {
			//保存用户与APP关系
			Map<String, Object> map = new HashMap<>();
			map.put("userId", userId);
			map.put("appIdList", appIdList);
			sysUserAppDao.save(map);
		}
	}

	@Override
	public List<Long> queryAppIdList(Long userId) {
		return sysUserAppDao.queryAppIdList(userId);
	}

	@Override
	public void delete(Long userId) {
		sysUserAppDao.delete(userId);
	}
}
