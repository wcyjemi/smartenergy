package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.cymall.common.utils.TreeTableBean;
import xin.cymall.dao.EnMonitorUnitDao;
import xin.cymall.entity.EnMonitorUnit;
import xin.cymall.service.EnMonitorUnitService;

import java.util.List;
import java.util.Map;


/**
 * 监测单位业务实现类
 * 
 * @author wcy
 * @date 2016年9月18日 上午9:46:09
 */
@Service("enMonitorUnitService")
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class EnMonitorUnitServiceImpl implements EnMonitorUnitService {
	@Autowired
	private EnMonitorUnitDao enMonitorUnitDao;

	@Override
	public EnMonitorUnit queryObject(String id) {
		return enMonitorUnitDao.queryObject(id);
	}

	@Override
	public List<EnMonitorUnit> queryByName(EnMonitorUnit enMonitorUnit){
		return enMonitorUnitDao.queryByName(enMonitorUnit);
	}

	@Override
	public List<EnMonitorUnit> queryList(Map<String, Object> map){
		return enMonitorUnitDao.queryList(map);
	}

	@Override
	public List<EnMonitorUnit> queryListByCompId(String companyId) {
		return enMonitorUnitDao.queryAllUnits(companyId);
	}

	@Override
	public List<TreeTableBean> queryTreeTable(Map param) {
		return enMonitorUnitDao.quertTreeTable(param);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return enMonitorUnitDao.queryTotal(map);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void save(EnMonitorUnit enMonitorUnit) {
		enMonitorUnit.preSave();
		enMonitorUnitDao.save(enMonitorUnit);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void update(EnMonitorUnit enMonitorUnit) {
		enMonitorUnit.preUpdate();
		enMonitorUnitDao.update(enMonitorUnit);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void deleteBatch(String[] ids) {
		enMonitorUnitDao.deleteBatch(ids);
	}

}
