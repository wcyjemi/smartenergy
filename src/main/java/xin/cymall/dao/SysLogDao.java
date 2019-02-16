package xin.cymall.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.SysLog;

/**
 * 系统日志
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2017-03-08 10:40:56
 */
@Mapper
@Repository
public interface SysLogDao extends BaseDao<SysLog> {
	
}
