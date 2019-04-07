package xin.cymall.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.cymall.dao.EnDeviceDao;
import xin.cymall.entity.EnDevice;
import xin.cymall.service.EnDeviceService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service("enDeviceService")
@Transactional
public class EnDeviceServiceImpl implements EnDeviceService {
	@Resource
	private EnDeviceDao enDeviceDao;
	
	@Override
	public EnDevice queryObject(String id){

		EnDevice info = enDeviceDao.queryObject(id);
		return info;
	}

	@Override
	public List<EnDevice> queryList(Map<String, Object> map){
		return enDeviceDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return enDeviceDao.queryTotal(map);
	}

	@Override
	public void save(EnDevice enDevice){
		enDevice.preSave();
		enDevice.preUpdate();
		enDevice.setId( UUID.randomUUID().toString());
		enDeviceDao.save(enDevice);
	}

	@Override
	public void update(EnDevice enDevice){
		enDevice.preUpdate();
		enDeviceDao.update(enDevice);
	}

	@Override
	public void delete(String id){
		enDeviceDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		enDeviceDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			EnDevice enDevice=queryObject(id);
			//enDevice.setState(stateValue);
            update(enDevice);
        }
    }
	
}
