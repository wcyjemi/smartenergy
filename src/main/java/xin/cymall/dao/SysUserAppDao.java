package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import xin.cymall.entity.SysUserApp;

import java.util.List;

/**
 * 用户与角色对应关系
 * 
 * @author wcy
 * @email 228112142@qq.com
 * @date 2016年9月18日 上午9:34:46
 */
@Mapper
@Repository
public interface SysUserAppDao extends BaseDao<SysUserApp> {
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryAppIdList(Long userId);
}
