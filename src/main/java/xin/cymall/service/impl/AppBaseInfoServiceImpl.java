package xin.cymall.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xin.cymall.dao.AppBaseInfoDao;
import xin.cymall.entity.AppBaseInfo;
import xin.cymall.service.AppBaseInfoService;


@Service("appBaseInfoService")
@Transactional
public class AppBaseInfoServiceImpl implements AppBaseInfoService {
	@Autowired
	private AppBaseInfoDao appBaseInfoDao;

	@Override
	public List<AppBaseInfo> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return appBaseInfoDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return appBaseInfoDao.queryTotal(map);
	}

	@Override
	public List<AppBaseInfo> findByVerify(AppBaseInfo appBaseInfo) {
		// TODO Auto-generated method stub
		return appBaseInfoDao.findByVerify(appBaseInfo);
	}

	@Override
	public void save(AppBaseInfo appBaseInfo) {
		// TODO Auto-generated method stub
		appBaseInfoDao.save(appBaseInfo);
	}

	@Override
	public AppBaseInfo queryObject(Integer id) {
		// TODO Auto-generated method stub
		return appBaseInfoDao.queryObject(id);
	}

	@Override
	public void update(AppBaseInfo appBaseInfo) {
		// TODO Auto-generated method stub
		appBaseInfoDao.update(appBaseInfo);
	}

	@Override
	public void updateBatch(Integer[] ids, String stateValue) {
		// TODO Auto-generated method stub
		appBaseInfoDao.updateStatusBatch(ids, stateValue);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		// TODO Auto-generated method stub
		appBaseInfoDao.deleteBatch(ids);
	}
	

}
