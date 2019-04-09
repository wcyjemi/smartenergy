package xin.cymall.dao;

import xin.cymall.common.utils.EnumBean;
import xin.cymall.entity.EnDevice;

import java.util.List;
import java.util.Map;

/**
 * 设备信息表
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-03 15:11:53
 */
public interface EnDeviceDao extends BaseDao<EnDevice> {
    /**
     * 所有设备
     * @param map
     * @return
     */
    List<EnumBean> queryAllList();
}
