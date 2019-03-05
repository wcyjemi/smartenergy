package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.Commpara;

import java.util.List;
import java.util.Map;

/**
 * 字典管理
 * 
 * @author chenyi
 * @email qq228112142@qq.com
 * @date 2017-11-06 14:49:28
 */
@Mapper
@Repository
public interface CommparaDao extends BaseDao<Commpara> {

    /**
     * 获取Code值
     * @param params
     * @return
     */
    List<Commpara> getCodeValues(Map<String, Object> params);

    /**
     * 验证查询
     * @param commpara
     * @return
     */
    List<Commpara> findByVerify(Commpara commpara);
}
