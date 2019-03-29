package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.EnCollector;


/**
 * 采集器信息表
 * 
 * @author zwg
 * @email 228112142@qq.com
 * @date 2019-03-25 20:59:22
 */
@Mapper
@Repository
public interface EnCollectorDao extends BaseDao<EnCollector> {
	
}
