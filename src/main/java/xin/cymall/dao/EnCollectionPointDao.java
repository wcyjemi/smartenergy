package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.EnCollectionPoint;
import xin.cymall.vo.EnCollectionPointVo;

import java.util.List;
import java.util.Map;

/**
 * 采集点信息表
 * 
 * @author wcy
 * @email 228112142@qq.com
 * @date 2019-03-19 11:10:52
 */
@Mapper
@Repository
public interface EnCollectionPointDao extends BaseDao<EnCollectionPoint> {
    EnCollectionPoint queryOneById(Object id);

    List<EnCollectionPointVo> queryTreeData(Map<String,Object> map);
}
