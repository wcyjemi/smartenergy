package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.EnCollectionPointDao;
import xin.cymall.entity.EnCollectionPoint;
import xin.cymall.service.EnCollectionPointService;


/**
 * 采集点业务service
 * @author wcy
 * @date 2019年3月19日11:20:33
 */
@Service("enCollectionPointService")
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class EnCollectionPointServiceImpl implements EnCollectionPointService {
	@Autowired
	private EnCollectionPointDao enCollectionPointDao;
	
	@Override
	public EnCollectionPoint queryObject(String id){
		return enCollectionPointDao.queryObject(id);
	}

	@Override
	public List<EnCollectionPoint> queryList(Map<String, Object> map){
		return enCollectionPointDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return enCollectionPointDao.queryTotal(map);
	}

	@Override
	public void save(EnCollectionPoint enCollectionPoint){
		enCollectionPoint.preSave();
		enCollectionPoint.preUpdate();
		enCollectionPointDao.save(enCollectionPoint);
	}

	@Override
	public void update(EnCollectionPoint enCollectionPoint){
		enCollectionPoint.preUpdate();
		enCollectionPointDao.update(enCollectionPoint);
	}

	@Override
	public void delete(String id){
		enCollectionPointDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		enCollectionPointDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			EnCollectionPoint enCollectionPoint=queryObject(id);
            update(enCollectionPoint);
        }
    }
	
}
