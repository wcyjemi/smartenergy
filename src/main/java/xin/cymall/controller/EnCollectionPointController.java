package xin.cymall.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import xin.cymall.common.enumresource.StateEnum;
import xin.cymall.common.log.SysLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

import xin.cymall.common.utils.*;
import xin.cymall.entity.EnCollectionPoint;
import xin.cymall.entity.EnConcentrator;
import xin.cymall.entity.EnInstructions;
import xin.cymall.entity.EnPoinstandardset;
import xin.cymall.service.EnCollectionPointService;
import xin.cymall.service.EnConcentratorService;
import xin.cymall.service.EnInstructionsService;
import xin.cymall.service.EnPoinstandardsetService;
import xin.cymall.vo.EnCollectionPointVo;


/**
 * 采集点信息表
 * 
 * @author wcy
 * @email 228112142@qq.com
 * @date 2019-03-19 11:10:52
 */
@Controller
@RequestMapping("/encollectionpoint")
public class EnCollectionPointController {
	@Autowired
	private EnCollectionPointService enCollectionPointService;

	@Autowired
	private EnPoinstandardsetService enPoinstandardsetService;

	@Autowired
	private EnInstructionsService enInstructionsService;

	@Autowired
	private EnConcentratorService enConcentratorService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("encollectionpoint:list")
    public String list() {
        return "collectionpoint/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("encollectionpoint:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EnCollectionPoint> enCollectionPointList = enCollectionPointService.queryList(query);
		int total = enCollectionPointService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(enCollectionPointList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 获取树形table数据
     * @param params
     * @return
     */
    @ResponseBody
    @RequestMapping("/treeTableData")
    public JSONArray treeTableData(@RequestParam Map<String,Object> params){
        List<EnCollectionPointVo> treeTableBeans = enCollectionPointService.queryTreeData(params);
        return JSONArray.parseArray(JSON.toJSONString(treeTableBeans));
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("encollectionpoint:save")
    public String add(){
        return "collectionpoint/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("encollectionpoint:update")
    public String edit(Model model, @PathVariable("id") String id){
		EnCollectionPoint enCollectionPoint = enCollectionPointService.queryObject(id);
		if (enCollectionPoint.getParentId().equals("0")){
		    enCollectionPoint.setCyNodeType(3);
        }else {
		    enCollectionPoint.setCyNodeType(4);
        }
        model.addAttribute("model",enCollectionPoint);
        return "collectionpoint/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("encollectionpoint:info")
    public R info(@PathVariable("id") String id){
        EnCollectionPoint enCollectionPoint = enCollectionPointService.queryObject(id);
        return R.ok().put("enCollectionPoint", enCollectionPoint);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存采集点信息表")
	@RequestMapping("/save")
	@RequiresPermissions("encollectionpoint:save")
	public R save(@RequestBody EnCollectionPoint enCollectionPoint){
        if (enCollectionPoint.getCyNodeType() == 3){
            enCollectionPoint.setParentId("0");
            enCollectionPoint.setParentIds("0");
        }
        if (enCollectionPoint.getCyNodeType() == 4){
            EnCollectionPoint enCollectionPoint1 = enCollectionPointService.queryObject(enCollectionPoint.getConcentratorId());
            enCollectionPoint.setConcentratorId(enCollectionPoint.getConcentratorId());
            enCollectionPoint.setParentId(enCollectionPoint1.getId());
            enCollectionPoint.setParentIds(enCollectionPoint1.getParentIds()+","+enCollectionPoint.getConcentratorId());
        }
		enCollectionPointService.save(enCollectionPoint);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改采集点信息表")
	@RequestMapping("/update")
	@RequiresPermissions("encollectionpoint:update")
	public R update(@RequestBody EnCollectionPoint enCollectionPoint){
		enCollectionPointService.update(enCollectionPoint);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用采集点信息表")
    @RequestMapping("/enable")
    @RequiresPermissions("encollectionpoint:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		enCollectionPointService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用采集点信息表")
    @RequestMapping("/limit")
    @RequiresPermissions("encollectionpoint:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		enCollectionPointService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除采集点信息表")
	@RequestMapping("/delete")
	@RequiresPermissions("encollectionpoint:delete")
	public R delete(@RequestBody String[] ids){
		enCollectionPointService.deleteBatch(ids);
		return R.ok();
	}

	@RequestMapping("/toSetStandard/{pointId}")
	public String toSetStandard(Model model,@PathVariable("pointId") String pointId){
        EnCollectionPoint enCollectionPoint = enCollectionPointService.queryOneById(pointId);
        enCollectionPoint.toTypeLabel();

        List<EnPoinstandardset> enPoinstandardsetList = enPoinstandardsetService.queryByPointId(pointId);

        if (enPoinstandardsetList == null || enPoinstandardsetList.size()<=0){
            Map<String,Object> param = new HashMap<>();
            param.put("instructionsType",enCollectionPoint.getPointType());
            List<EnInstructions> enInstructionsList = enInstructionsService.queryListAll(param);
            if (enInstructionsList == null || enInstructionsList.size()<=0){
                enPoinstandardsetList = new ArrayList<>();
            }else {
                for (EnInstructions enInstructions : enInstructionsList){
                    EnPoinstandardset enPoinstandardset = new EnPoinstandardset();
                    enPoinstandardset.setCollectionPointId(pointId);
                    enPoinstandardset.setInstructionsId(enInstructions.getId());
                    enPoinstandardset.setInstructionName(enInstructions.getInstructionsName());
                    enPoinstandardsetList.add(enPoinstandardset);
                }
            }
        }
        model.addAttribute("model",enCollectionPoint);
        model.addAttribute("data",enPoinstandardsetList);
        return "collectionpoint/setstandard";
    }

	@RequestMapping("/toSetStandardTb/{pointId}")
	public String toSetStandardTb(Model model,@PathVariable("pointId") String pointId){
        EnCollectionPoint enCollectionPoint = enCollectionPointService.queryObject(pointId);
        model.addAttribute("model",enCollectionPoint);
        return "collectionpoint/setstandard_tb";
    }

    @ResponseBody
    @RequestMapping("/getPointStandard/{pointId}")
    public R getPointStandard(@PathVariable("pointId") String pointId){
        List<EnPoinstandardset> list = new ArrayList<>();
        for (int i=0;i<5;i++){
            EnPoinstandardset enPoinstandardset = new EnPoinstandardset();
            enPoinstandardset.setCollectionPointId(pointId);
            enPoinstandardset.setInstructionsId(i+"");
            enPoinstandardset.setInstructionName("电压"+i);
            list.add(enPoinstandardset);
        }
        return R.ok().put("data",list);
    }

    @ResponseBody
    @RequestMapping(value = "/standarSetSave",method = RequestMethod.POST)
    public R standarSetSave(@RequestBody Map<String,Object> map){
        try {
            for (int i = 0; i<map.size()/6; i++){
                EnPoinstandardset enPoinstandardset = new EnPoinstandardset();
                enPoinstandardset.setId(map.get("enPoinstandardsets["+i+"].id").toString());
                enPoinstandardset.setInstructionsId(map.get("enPoinstandardsets["+i+"].instructionsId").toString());
                enPoinstandardset.setInstructionName(map.get("enPoinstandardsets["+i+"].instructionName").toString());
                enPoinstandardset.setCollectionPointId(map.get("enPoinstandardsets["+i+"].collectionPointId").toString());
                enPoinstandardset.setStandardValueMin(map.get("enPoinstandardsets["+i+"].standardValueMin").toString());
                enPoinstandardset.setStandardValueMax(map.get("enPoinstandardsets["+i+"].standardValueMax").toString());
                if (StringUtil.isBlank(enPoinstandardset.getId())){
                    enPoinstandardsetService.save(enPoinstandardset);
                }else {
                    enPoinstandardsetService.update(enPoinstandardset);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error("系统异常");
        }
        return R.ok();
    }
	
}
