package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.EnCompany;

/**
 * 企业信息 mapper
 * @author wcy
 * @date 2019年2月28日16:28:21
 */
@Mapper
@Repository
public interface EnCompanyDao extends BaseDao<EnCompany>{

    /**
     * 修改企业序列号
     * @param enCompany
     */
    void updateCompanyKey(@Param("enCompany") EnCompany enCompany);

}
