package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.EnElecBaseDataDao;
import xin.cymall.entity.EnElecBaseData;
import xin.cymall.service.EnElecBaseDataService;




@Service("enElecBaseDataService")
@Transactional
public class EnElecBaseDataServiceImpl implements EnElecBaseDataService {
	@Autowired
	private EnElecBaseDataDao enElecBaseDataDao;
	
	@Override
	public EnElecBaseData queryObject(String id){
		return enElecBaseDataDao.queryObject(id);
	}

    @Override
    public EnElecBaseData queryAnyCclumnSort(Map<String, Object> map) {
        return enElecBaseDataDao.queryAnyCclumnSort(map);
    }

	@Override
	public Float queryAnyCclumnAvg(Map<String, Object> map) {
		return enElecBaseDataDao.queryAnyCclumnAvg(map);
	}

	@Override
	public List<EnElecBaseData> queryList(Map<String, Object> map){
		return enElecBaseDataDao.queryList(map);
	}

	@Override
	public ArrayList<String> getXtimeArr(Map<String, Object> map) {
		return enElecBaseDataDao.getXtimeArr(map);
	}

	@Override
	public ArrayList<String> getRealPowAtData(Map<String, Object> map) {
		return enElecBaseDataDao.getRealPowAtData(map);
	}

	@Override
	public List<EnElecBaseData> getRealData(Map<String, Object> map) {
		return enElecBaseDataDao.getRealData(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return enElecBaseDataDao.queryTotal(map);
	}

	@Override
	public void save(EnElecBaseData enElecBaseData){
		enElecBaseDataDao.save(enElecBaseData);
	}

	@Override
	public void update(EnElecBaseData enElecBaseData){
		enElecBaseDataDao.update(enElecBaseData);
	}

	@Override
	public void delete(String id){
		enElecBaseDataDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		enElecBaseDataDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			EnElecBaseData enElecBaseData=queryObject(id);
            update(enElecBaseData);
        }
    }
	
}
