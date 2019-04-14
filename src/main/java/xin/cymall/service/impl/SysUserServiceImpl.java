package xin.cymall.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.cymall.common.enumresource.DefaultEnum;
import xin.cymall.common.exception.MyException;
import xin.cymall.common.utils.Constant;
import xin.cymall.dao.SysUserDao;
import xin.cymall.entity.SysUser;
import xin.cymall.service.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 系统用户
 * 
 * @author wcy
 * @date 2016年9月18日 上午9:46:09
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysUserCompanyService sysUserCompanyService;

	@Override
	public List<String> queryAllPerms(Long userId) {
		return sysUserDao.queryAllPerms(userId);
	}

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return sysUserDao.queryAllMenuId(userId);
	}

	@Override
	public SysUser queryByUserName(String username) {
		return sysUserDao.queryByUserName(username);
	}
	
	@Override
	public SysUser queryObject(Long userId) {
		return sysUserDao.queryObject(userId);
	}

	@Override
	public List<SysUser> queryList(Map<String, Object> map){
		return sysUserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysUserDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(SysUser user) {
		user.setCreateTime(new Date());
		//sha256加密
		user.setPassword(new Sha256Hash(DefaultEnum.PASSWORD.getCode()).toHex());
		sysUserDao.save(user);
		
		//检查角色是否越权
		checkRole(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
//		//保存用户与APP关系
//		sysUserAppService.saveOrUpdate(user.getUserId(), user.getAppIdList());
		//保存用户与企业关系
		sysUserCompanyService.saveOrUpdate(user.getUserId(), user.getCompanyIds());

	}

	@Override
	@Transactional
	public void update(SysUser user) {
		if(StringUtils.isBlank(user.getPassword())){
			user.setPassword(null);
		}else{
			user.setPassword(new Sha256Hash(user.getPassword()).toHex());
		}
		sysUserDao.update(user);
		
		//检查角色是否越权
		checkRole(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
//		//保存用户与APP关系
//		sysUserAppService.saveOrUpdate(user.getUserId(), user.getAppIdList());
		//保存用户与企业关系
		sysUserCompanyService.saveOrUpdate(user.getUserId(), user.getCompanyIds());
	}

	@Override
	@Transactional
	public void deleteBatch(Long[] userId) {
		sysUserDao.deleteBatch(userId);
		sysUserDao.deleteUserRole(userId);
		sysUserDao.deleteUserCompany(userId);
	}

	@Override
	public int updatePassword(Long userId, String password, String newPassword) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("password", password);
		map.put("newPassword", newPassword);
		return sysUserDao.updatePassword(map);
	}

	@Override
	public void initPassword(Long[] userIds) {
		for (long userId:userIds) {
			SysUser user=queryObject(userId);
			user.setPassword(new Sha256Hash(DefaultEnum.PASSWORD.getCode()).toHex());
			sysUserDao.update(user);
		}
	}

	/**
	 * 检查角色是否越权
	 */
	private void checkRole(SysUser user){
		//如果不是超级管理员，则需要判断用户的角色是否自己创建
		if(user.getCreateUserId() == Constant.SUPER_ADMIN){
			return ;
		}
		
		//查询用户创建的角色列表
		List<Long> roleIdList = sysRoleService.queryRoleIdList(user.getCreateUserId());
		
		//判断是否越权
		if(!roleIdList.containsAll(user.getRoleIdList())){
			throw new MyException("新增用户所选角色，不是本人创建");
		}
	}
}
