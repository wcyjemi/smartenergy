package xin.cymall.dao;

import xin.cymall.entity.EnInstructions;

import java.util.List;
import java.util.Map;

/**
 * 数据项信息
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-03 10:42:59
 */
public interface EnInstructionsDao extends BaseDao<EnInstructions> {
    List<EnInstructions> queryListAll(Map<String,Object> map);
}
