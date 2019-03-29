package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.EnConcentratorDao;
import xin.cymall.entity.EnConcentrator;
import xin.cymall.service.EnConcentratorService;




@Service("enConcentratorService")
@Transactional
public class EnConcentratorServiceImpl implements EnConcentratorService {
	@Autowired
	private EnConcentratorDao enConcentratorDao;

	@Override
	public EnConcentrator queryObject(String id){
		return enConcentratorDao.queryObject(id);
	}

	@Override
	public List<EnConcentrator> queryList(Map<String, Object> map){
		return enConcentratorDao.queryList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return enConcentratorDao.getCount(map);
	}

	@Override
	public void save(EnConcentrator enConcentrator){
		enConcentrator.preSave();
		enConcentrator.preUpdate();
		enConcentratorDao.save(enConcentrator);
	}

	@Override
	public void update(EnConcentrator enConcentrator){
		enConcentratorDao.update(enConcentrator);
	}

	@Override
	public void delete(String id){
		enConcentratorDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		enConcentratorDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			EnConcentrator enConcentrator=queryObject(id);
            update(enConcentrator);
        }
    }
	
}
