package xin.cymall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;
import xin.cymall.entity.AppBaseInfo;

/**
 * @author wcy
 * @date 2019年1月2日15:03:01
 */
@Mapper
@Repository
public interface AppBaseInfoDao extends BaseDao<AppBaseInfo> {
	List<AppBaseInfo> findByVerify(AppBaseInfo appBaseInfo);
	
	int updateStatusBatch(@Param(value = "array")Object[] array,@Param(value = "value")Object value);
}
