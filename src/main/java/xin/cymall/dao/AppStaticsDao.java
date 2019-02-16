package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xin.cymall.common.utils.EnumBean;
import xin.cymall.entity.AppUpdRecord;

import java.util.List;
import java.util.Map;

/**
 * @author wcy
 * @date 2019年1月2日15:03:01
 */
@Mapper
@Repository
public interface AppStaticsDao{
    List<EnumBean> appDayUpdCount(Map<String,Object> param);
    List<EnumBean> appZbPie();
}
