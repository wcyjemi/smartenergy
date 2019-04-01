package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.EnCompanyVisitDao;
import xin.cymall.entity.EnCompanyVisit;
import xin.cymall.service.EnCompanyVisitService;




@Service("enCompanyVisitService")
@Transactional
public class EnCompanyVisitServiceImpl implements EnCompanyVisitService {
	@Autowired
	private EnCompanyVisitDao enCompanyVisitDao;
	
	@Override
	public EnCompanyVisit queryObject(String id){
		return enCompanyVisitDao.queryObject(id);
	}

	@Override
	public List<EnCompanyVisit> queryList(Map<String, Object> map){
		return enCompanyVisitDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return enCompanyVisitDao.queryTotal(map);
	}

	@Override
	public void save(EnCompanyVisit enCompanyVisit){
		enCompanyVisit.preSave();
		enCompanyVisit.preUpdate();
		enCompanyVisitDao.save(enCompanyVisit);
	}

	@Override
	public void update(EnCompanyVisit enCompanyVisit){
		enCompanyVisit.preUpdate();
		enCompanyVisitDao.update(enCompanyVisit);
	}

	@Override
	public void delete(String id){
		enCompanyVisitDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		enCompanyVisitDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			EnCompanyVisit enCompanyVisit=queryObject(id);
            update(enCompanyVisit);
        }
    }
	
}
