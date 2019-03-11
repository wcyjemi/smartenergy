package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.EnCompany;
import xin.cymall.entity.EnMonitorUnit;

import java.util.List;

/**
 * 监测单位 mapper
 * @author wcy
 * @date 2019年2月28日16:28:21
 */
@Mapper
@Repository
public interface EnMonitorUnitDao extends BaseDao<EnMonitorUnit>{

    /**
     * 根据名称查询监测单位
     * @param enMonitorUnit
     * @return
     */
    List<EnMonitorUnit> queryByName(@Param("enMonitorUnit") EnMonitorUnit enMonitorUnit);

}
