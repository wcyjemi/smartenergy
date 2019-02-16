package xin.cymall.service;

import xin.cymall.common.utils.EnumBean;

import java.util.List;
import java.util.Map;

/**
 * 
 * 数据统计service
 * @author wcy
 * @date 2019年1月3日14:27:48
 */
public interface AppStaticsService {

	List<EnumBean> appDayUpdCount(Map<String, Object> map);
	List<EnumBean> appZbPie();

}
