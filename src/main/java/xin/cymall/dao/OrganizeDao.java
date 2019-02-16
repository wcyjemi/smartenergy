package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.Organize;

import java.util.List;

/**
 * 记录组织机构管理信息
 * 
 * @author chenyi
 * @email qq228112142@qq.com
 * @date 2017-11-06 17:39:31
 */
@Mapper
@Repository
public interface OrganizeDao extends BaseDao<Organize> {

    List<Organize> getList();

    List<Organize> queryByParentId(String orgId);

    Organize queryByOrgCode(String orgCode);
}
