package xin.cymall.service;

import java.util.List;


/**
 * 用户与角色对应关系
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2016年9月18日 上午9:43:24
 */
public interface SysUserCompanyService {
	
	void saveOrUpdate(Long userId, List<String> companyIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<String> queryCompanyIdList(Long userId);
	
	void delete(Long userId);
}
