package xin.cymall.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.cymall.common.enumresource.DefaultEnum;
import xin.cymall.common.exception.MyException;
import xin.cymall.common.utils.Constant;
import xin.cymall.common.utils.EnumBean;
import xin.cymall.common.utils.ZtreeBean;
import xin.cymall.dao.EnCompanyDao;
import xin.cymall.dao.SysUserDao;
import xin.cymall.entity.EnCompany;
import xin.cymall.entity.SysUser;
import xin.cymall.service.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 企业信息业务实现类
 * 
 * @author wcy
 * @date 2016年9月18日 上午9:46:09
 */
@Service("enCompanyService")
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class EnCompanyServiceImpl implements EnCompanyService {
	@Autowired
	private EnCompanyDao enCompanyDao;

	@Override
	public EnCompany queryObject(String id) {
		return enCompanyDao.queryObject(id);
	}

	@Override
	public List<EnCompany> queryByName(EnCompany enCompany){
		return enCompanyDao.queryByName(enCompany);
	}

	@Override
	public List<EnCompany> queryList(Map<String, Object> map){
		return enCompanyDao.queryList(map);
	}

	@Override
	public List<EnumBean> queryCodeAndValue(){
		return enCompanyDao.queryCodeAndValue();
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return enCompanyDao.queryTotal(map);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void save(EnCompany enCompany) {
		enCompany.preSave();
		enCompany.toAreaPath();
		enCompany.toPinYing();
		enCompanyDao.save(enCompany);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void update(EnCompany enCompany) {
		enCompany.preUpdate();
		enCompany.toAreaPath();
		enCompany.toPinYing();
		enCompanyDao.update(enCompany);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void deleteBatch(String[] ids) {
		enCompanyDao.deleteBatch(ids);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void updateCompanyKey(EnCompany enCompany) {
		enCompany.generKey();
		enCompany.preUpdate();
		enCompanyDao.updateCompanyKey(enCompany);
	}

	@Override
	public List<ZtreeBean> sysJgTreeData(Map<String,Object> param) {
		return enCompanyDao.queryJgTreeData(param);
	}
}
