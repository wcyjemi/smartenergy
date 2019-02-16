package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.cymall.common.utils.EnumBean;
import xin.cymall.dao.AppStaticsDao;
import xin.cymall.dao.AppUpdRecordDao;
import xin.cymall.entity.AppUpdRecord;
import xin.cymall.service.AppStaticsService;
import xin.cymall.service.AppUpdRecordService;

import java.util.List;
import java.util.Map;

@Service("appStaticsService")
@Transactional
public class AppStaticsServiceImpl implements AppStaticsService {
	@Autowired
	private AppStaticsDao appStaticsDao;

	@Override
	public List<EnumBean> appDayUpdCount(Map<String, Object> map) {
		return appStaticsDao.appDayUpdCount(map);
	}

	@Override
	public List<EnumBean> appZbPie() {
		return appStaticsDao.appZbPie();
	}
}
