package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.EnCollectorDao;
import xin.cymall.entity.EnCollector;
import xin.cymall.service.EnCollectorService;




@Service("enCollectorService")
@Transactional
public class EnCollectorServiceImpl implements EnCollectorService {
	@Autowired
	private EnCollectorDao enCollectorDao;
	
	@Override
	public EnCollector queryObject(String id){
		return enCollectorDao.queryObject(id);
	}

	@Override
	public List<EnCollector> queryList(Map<String, Object> map){
		return enCollectorDao.queryList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return enCollectorDao.getCount(map);
	}

	@Override
	public void save(EnCollector enCollector){

		enCollector.preSave();
		enCollector.preUpdate();

		enCollectorDao.save(enCollector);
	}

	@Override
	public void update(EnCollector enCollector){
		enCollectorDao.update(enCollector);
	}

	@Override
	public void delete(String id){
		enCollectorDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		enCollectorDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			EnCollector enCollector=queryObject(id);
            update(enCollector);
        }
    }
	
}
