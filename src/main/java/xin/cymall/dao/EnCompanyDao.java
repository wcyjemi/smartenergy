package xin.cymall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xin.cymall.entity.EnCompany;

import java.util.List;

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

    /**
     * 根据名称查询企业
     * @param enCompany
     * @return
     */
    List<EnCompany> queryByName(@Param("enCompany") EnCompany enCompany);

}
