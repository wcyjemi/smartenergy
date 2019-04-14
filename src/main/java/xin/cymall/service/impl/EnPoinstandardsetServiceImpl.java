package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.EnPoinstandardsetDao;
import xin.cymall.entity.EnPoinstandardset;
import xin.cymall.service.EnPoinstandardsetService;

/**
 * 监测点数据项标准值设置 业务实现类
 *
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-02 15:59:22
 */
@Service("enPoinstandardsetService")
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class EnPoinstandardsetServiceImpl implements EnPoinstandardsetService {
	@Autowired
	private EnPoinstandardsetDao enPoinstandardsetDao;

	@Override
	public EnPoinstandardset queryObject(String id){
		return enPoinstandardsetDao.queryObject(id);
	}

	@Override
	public List<EnPoinstandardset> queryList(Map<String, Object> map){
		return enPoinstandardsetDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return enPoinstandardsetDao.queryTotal(map);
	}

	@Override
	public List<EnPoinstandardset> queryByPointId(String pointId) {
		return enPoinstandardsetDao.queryByPointId(pointId);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void save(EnPoinstandardset enPoinstandardset){
		enPoinstandardset.preSave();
		enPoinstandardset.preUpdate();
		enPoinstandardsetDao.save(enPoinstandardset);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void update(EnPoinstandardset enPoinstandardset){
		enPoinstandardset.preUpdate();
		enPoinstandardsetDao.update(enPoinstandardset);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void delete(String id){
		enPoinstandardsetDao.delete(id);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void deleteBatch(String[] ids){
		enPoinstandardsetDao.deleteBatch(ids);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void updateState(String[] ids,String stateValue) {
		for (String id:ids){
			EnPoinstandardset enPoinstandardset=queryObject(id);
			update(enPoinstandardset);
		}
	}
}
