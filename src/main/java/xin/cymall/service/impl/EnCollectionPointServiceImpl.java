package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.EnCollectionPointDao;
import xin.cymall.entity.EnCollectionPoint;
import xin.cymall.entity.EnCompany;
import xin.cymall.service.EnCollectionPointService;
import xin.cymall.vo.EnCollectionPointVo;


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
	public EnCollectionPoint queryOneById(String id){
		return enCollectionPointDao.queryOneById(id);
	}

	@Override
	public List<EnCollectionPoint> queryList(Map<String, Object> map){
		return enCollectionPointDao.queryList(map);
	}

	@Override
	public List<EnCollectionPointVo> queryTreeData(Map<String, Object> map) {
		return enCollectionPointDao.queryTreeData(map);
	}

	@Override
	public List<EnCollectionPoint> queryAllParent(Map<String, Object> map) {
		return enCollectionPointDao.queryAllParent(map);
	}

	@Override
	public List<EnCollectionPoint> queryChildrenByParent(Map<String, Object> map) {
		return enCollectionPointDao.queryChildrenByParent(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return enCollectionPointDao.queryTotal(map);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void save(EnCollectionPoint enCollectionPoint){
		enCollectionPoint.preSave();
		enCollectionPoint.preUpdate();
		enCollectionPointDao.save(enCollectionPoint);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void update(EnCollectionPoint enCollectionPoint){
		enCollectionPoint.preUpdate();
		enCollectionPointDao.update(enCollectionPoint);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void delete(String id){
		enCollectionPointDao.delete(id);
	}

	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public void deleteBatch(String[] ids){
		enCollectionPointDao.deleteBatch(ids);
	}

    @Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			EnCollectionPoint enCollectionPoint=queryObject(id);
            update(enCollectionPoint);
        }
    }

	@Override
	public List<Map<String, Object>> getPointTreeView(List<EnCompany> companies) {
		List<Map<String, Object>> res = new ArrayList<>();
		for (EnCompany enCompany : companies){
			Map<String, Object> map = new HashMap<>();
			map.put("text",enCompany.getCompanyName());
			map.put("icon","companyIcon");
			map.put("id",enCompany.getId());
			map.put("selectable",false);

			Map<String, Object> param = new HashMap<>();
			param.put("companyId", enCompany.getId());
			List<EnCollectionPoint> enCollectionPointList = queryAllParent(param);
			if (enCollectionPointList != null && enCollectionPointList.size()>0){
				List<Map<String,Object>> mmap = new ArrayList<>();
				for (EnCollectionPoint enCollectionPoint : enCollectionPointList){
					Map<String, Object> map1 = new HashMap<>();
					map1.put("text",enCollectionPoint.getCollectionPointName());
					map1.put("id",enCollectionPoint.getId());
					map1.put("icon","pointIcon");
					map1.put("selectable",true);
					map1.put("nodes",getPointNodes(enCollectionPoint.getId()));
					mmap.add(map1);
				}
				map.put("nodes",mmap);
			}
			res.add(map);

		}
		return res;
	}

	public List<Map<String, Object>> getPointNodes(String parentId){
		List<Map<String,Object>> res = new ArrayList<>();
		Map<String,Object> param = new HashMap<>();
		param.put("parentId",parentId);
		List<EnCollectionPoint> enCollectionPoints = enCollectionPointDao.queryChildrenByParent(param);
		if (enCollectionPoints != null && enCollectionPoints.size()>0){
			for (EnCollectionPoint enCollectionPoint : enCollectionPoints){
				Map<String,Object> map = new HashMap<>();
				map.put("text",enCollectionPoint.getCollectionPointName());
				map.put("id",enCollectionPoint.getId());
				map.put("icon","pointIcon");
				map.put("selectable",true);
				map.put("nodes",getPointNodes(enCollectionPoint.getId()));
				res.add(map);
			}
		}
		return res;
	}

}
