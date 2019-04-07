package xin.cymall.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.cymall.dao.EnWarningInfoDao;
import xin.cymall.entity.EnWarningInfo;
import xin.cymall.service.EnWarningInfoService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service("enWarningInfoService")
@Transactional
public class EnWarningInfoServiceImpl implements EnWarningInfoService {


	@Resource
	private EnWarningInfoDao enWarningInfoDao;
	
	@Override
	public EnWarningInfo queryObject(String id){
		return enWarningInfoDao.queryObject(id);
	}

	@Override
	public List<EnWarningInfo> queryList(Map<String, Object> map){
		return enWarningInfoDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return enWarningInfoDao.queryTotal(map);
	}

	@Override
	public void save(EnWarningInfo enWarningInfo){
		//预留设置等级为空
		enWarningInfo.setWarningLevel("");
		String arrStander[] = enWarningInfo.getStandardValue().split("-");
		//当前值
		Double currentValue = Double.parseDouble( enWarningInfo.getCurrentValue());
		//标准值最小值
		Double standardMinValue = Double.parseDouble(arrStander[0]);
		//标准最大值
		Double standardMaxValue = Double.parseDouble(arrStander[1]);
		//判断是高于还是低于
		if(currentValue < standardMinValue){
			enWarningInfo.setDifferenceValue("2");
			enWarningInfo.setDifferenceValue((standardMinValue - currentValue) + "");
			enWarningInfo.setPercentageValue((standardMinValue - currentValue)/standardMinValue + "");
		}else if(currentValue > standardMaxValue){
			enWarningInfo.setDifferenceValue("1");
			enWarningInfo.setDifferenceValue((currentValue - standardMaxValue) + "");
			enWarningInfo.setPercentageValue((currentValue - standardMaxValue)/standardMaxValue + "");
		}else{
			enWarningInfo.setDifferenceValue("");
		}

		if(!"".equals(enWarningInfo.getDifferenceValue())){
			enWarningInfo.preSave();
			enWarningInfo.preUpdate();
			enWarningInfo.setId( UUID.randomUUID().toString());
			enWarningInfoDao.save(enWarningInfo);
		}
	}


	
}
