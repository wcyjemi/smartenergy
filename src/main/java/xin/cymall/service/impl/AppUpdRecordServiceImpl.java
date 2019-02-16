package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.cymall.dao.AppUpdRecordDao;
import xin.cymall.entity.AppUpdRecord;
import xin.cymall.service.AppUpdRecordService;
import java.util.List;
import java.util.Map;

@Service("appUpdRecordService")
@Transactional
public class AppUpdRecordServiceImpl implements AppUpdRecordService {
	@Autowired
	private AppUpdRecordDao appUpdRecordDao;

	@Override
	public List<AppUpdRecord> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return appUpdRecordDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return appUpdRecordDao.queryTotal(map);
	}

	@Override
	public void save(AppUpdRecord appUpdRecord){
		// TODO Auto-generated method stub
		appUpdRecordDao.save(appUpdRecord);
	}

	@Override
	public AppUpdRecord queryObject(Integer id) {
		// TODO Auto-generated method stub
		return appUpdRecordDao.queryObject(id);
	}

	@Override
	public void update(AppUpdRecord appUpdRecord) {
		// TODO Auto-generated method stub
		appUpdRecordDao.update(appUpdRecord);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		// TODO Auto-generated method stub
		appUpdRecordDao.deleteBatch(ids);
	}
	

}
