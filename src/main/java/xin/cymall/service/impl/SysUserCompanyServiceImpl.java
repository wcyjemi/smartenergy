package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.cymall.dao.SysUserCompanyDao;
import xin.cymall.dao.SysUserRoleDao;
import xin.cymall.service.SysUserCompanyService;
import xin.cymall.service.SysUserRoleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户与角色对应关系
 * 
 * @author wcy
 * @date 2016年9月18日 上午9:45:48
 */
@Service("sysUserCompanyService")
public class SysUserCompanyServiceImpl implements SysUserCompanyService {
	@Autowired
	private SysUserCompanyDao sysUserCompanyDao;

	@Override
	public void saveOrUpdate(Long userId, List<String> companyIds) {
//		if(roleIdList==null||roleIdList.size() == 0){
//			return ;
//		}
		//先删除用户与角色关系
		sysUserCompanyDao.delete(userId);
		
		//保存用户与角色关系
		if (companyIds.size()>0) {
			Map<String, Object> map = new HashMap<>();
			map.put("userId", userId);
			map.put("companyIds", companyIds);
			sysUserCompanyDao.save(map);
		}
	}

	@Override
	public List<String> queryCompanyIdList(Long userId) {
		return sysUserCompanyDao.queryComapnyList(userId);
	}

	@Override
	public void delete(Long userId) {
		sysUserCompanyDao.delete(userId);
	}
}
