package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import xin.cymall.dao.EnMaintainPlanDao;
import xin.cymall.entity.EnMaintainPlan;
import xin.cymall.service.EnMaintainPlanService;

import javax.annotation.Resource;


@Service("enMaintainPlanService")
@Transactional
public class EnMaintainPlanServiceImpl implements EnMaintainPlanService {
	@Resource
	private EnMaintainPlanDao enMaintainPlanDao;
	
	@Override
	public EnMaintainPlan queryObject(String id){
		return enMaintainPlanDao.queryObject(id);
	}

	@Override
	public List<EnMaintainPlan> queryList(Map<String, Object> map){
		return enMaintainPlanDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){

		return enMaintainPlanDao.queryTotal(map);
	}

	@Override
	public void save(EnMaintainPlan enMaintainPlan){
		enMaintainPlan.preSave();
		enMaintainPlan.preUpdate();
		enMaintainPlan.setId( UUID.randomUUID().toString());
		enMaintainPlanDao.save(enMaintainPlan);
	}

	@Override
	public void update(EnMaintainPlan enMaintainPlan){
		enMaintainPlan.preUpdate();
		enMaintainPlanDao.update(enMaintainPlan);
	}

	@Override
	public void delete(String id){
		enMaintainPlanDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		enMaintainPlanDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			EnMaintainPlan enMaintainPlan=queryObject(id);
            update(enMaintainPlan);
        }
    }
	
}
