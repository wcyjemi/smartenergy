package xin.cymall.service;

import java.util.List;


/**
 * 用户与APP对应关系
 * 
 * @author wcy
 * @date 2019年1月3日17:52:10
 */
public interface SysUserAppService {
	
	void saveOrUpdate(Long userId, List<Long> appIdList);
	
	/**
	 * 根据用户ID，获取APP ID列表
	 */
	List<Long> queryAppIdList(Long userId);
	
	void delete(Long userId);
}
