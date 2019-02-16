package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.AppUpdRecord;
import xin.cymall.entity.AppVersion;

import java.util.List;

/**
 * @author wcy
 * @date 2019年1月2日15:03:01
 */
@Mapper
@Repository
public interface AppUpdRecordDao extends BaseDao<AppUpdRecord> {
}
