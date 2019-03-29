package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.EnConcentrator;

/**
 * 集中器信息表
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-03-28 14:44:28
 */
@Mapper
@Repository
public interface EnConcentratorDao extends BaseDao<EnConcentrator> {
	
}
