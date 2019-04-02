package xin.cymall.service;

import io.swagger.models.auth.In;
import xin.cymall.common.utils.EnumBean;
import xin.cymall.common.utils.ZtreeBean;
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
	EnCompany queryObject(String id);

	/**
	 * 根据企业名称查询
	 * @param enCompany
	 * @return
	 */
	List<EnCompany> queryByName(EnCompany enCompany);
	
	/**
	 * 查询企业列表
	 * @param map
	 * @return
	 */
	List<EnCompany> queryList(Map<String, Object> map);


	/**
	 * 查询企业键值对
	 * @return
	 */
	List<EnumBean> queryCodeAndValue();
	
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
	void deleteBatch(String[] ids);
	
	/**
	 * 修改企业序列号
	 * @param enCompany      企业信息
	 * @return
	 */
	void updateCompanyKey(EnCompany enCompany);

	/**
	 * 查询树形结构 企业 建筑 监测点
	 * @param param
	 * @return
	 */
	List<ZtreeBean> sysJgTreeData(Map<String,Object> param);

}
