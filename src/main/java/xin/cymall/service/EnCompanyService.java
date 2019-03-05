package xin.cymall.service;

import xin.cymall.entity.EnCompany;
import xin.cymall.entity.SysUser;

import java.util.List;
import java.util.Map;


/**
 * 企业信息 业务类 service
 * @author wcy
 * @date 2019年3月1日14:46:53
 */
public interface EnCompanyService {
	

	/**
	 * 根据用户ID，查询企业信息
	 * @param id
	 * @return
	 */
	EnCompany queryObject(Integer id);
	
	/**
	 * 查询企业列表
	 * @param map
	 * @return
	 */
	List<EnCompany> queryList(Map<String, Object> map);
	
	/**
	 * 查询总数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);
	
	/**
	 * 保存企业信息
	 * @param enCompany
	 * @return
	 */
	void save(EnCompany enCompany);
	
	/**
	 * 修改企业信息
	 * @param enCompany
	 * @return
	 */
	void update(EnCompany enCompany);
	
	/**
	 * 删除企业信息
	 * @param ids
	 * @return
	 */
	void deleteBatch(Integer[] ids);
	
	/**
	 * 修改企业序列号
	 * @param enCompany      企业信息
	 * @return
	 */
	void updateCompanyKey(EnCompany enCompany);

}
