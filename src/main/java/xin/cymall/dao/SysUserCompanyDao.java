package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.SysRoleMenu;
import xin.cymall.entity.SysUserCompany;

import java.util.List;

/**
 * 角色与菜单对应关系
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2016年9月18日 上午9:33:46
 */
@Mapper
@Repository
public interface SysUserCompanyDao extends BaseDao<SysUserCompany> {
	
	/**
	 * 根据角色ID，获取企业ID列表
	 */
	List<String> queryComapnyList(Long roleId);
}
