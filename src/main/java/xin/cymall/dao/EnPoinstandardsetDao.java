package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.EnPoinstandardset;

import java.util.List;

/**
 * 监测点数据项标准值设置
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-02 15:59:22
 */
@Mapper
@Repository
public interface EnPoinstandardsetDao extends BaseDao<EnPoinstandardset> {

    List<EnPoinstandardset> queryByPointId(String pointId);
	
}
