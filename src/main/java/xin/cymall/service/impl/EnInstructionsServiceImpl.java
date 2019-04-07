package xin.cymall.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin.util.UIUtil;
import xin.cymall.dao.EnInstructionsDao;
import xin.cymall.entity.EnInstructions;
import xin.cymall.service.EnInstructionsService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service("enInstructionsService")
@Transactional
public class EnInstructionsServiceImpl implements EnInstructionsService {
	@Resource
	private EnInstructionsDao enInstructionsDao;
	
	@Override
	public EnInstructions queryObject(String id){
		return enInstructionsDao.queryObject(id);
	}

	@Override
	public List<EnInstructions> queryList(Map<String, Object> map){
		return enInstructionsDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return enInstructionsDao.queryTotal(map);
	}

	@Override
	public void save(EnInstructions enInstructions){
		enInstructions.preSave();
		enInstructions.preUpdate();
		enInstructions.setId( UUID.randomUUID().toString());
		enInstructionsDao.save(enInstructions);
	}

	@Override
	public void update(EnInstructions enInstructions){
		enInstructionsDao.update(enInstructions);
	}

	@Override
	public void delete(String id){
		enInstructionsDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		enInstructionsDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			EnInstructions enInstructions=queryObject(id);
			//enInstructions.setState(stateValue);
            update(enInstructions);
        }
    }
	
}
