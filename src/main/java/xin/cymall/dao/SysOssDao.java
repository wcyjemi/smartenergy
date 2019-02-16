package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.SysOss;

/**
 * oss配置
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2017-12-13 10:07:04
 */
@Mapper
@Repository
public interface SysOssDao extends BaseDao<SysOss> {
	
}
