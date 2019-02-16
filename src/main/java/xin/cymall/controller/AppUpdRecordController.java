package xin.cymall.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.exception.MyException;
import xin.cymall.common.log.SysLog;
import xin.cymall.common.shiro.ShiroUtils;
import xin.cymall.common.utils.EnumBean;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;
import xin.cymall.entity.AppBaseInfo;
import xin.cymall.entity.AppUpdRecord;
import xin.cymall.entity.AppVersion;
import xin.cymall.service.AppBaseInfoService;
import xin.cymall.service.AppUpdRecordService;
import xin.cymall.service.AppVersionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * APP基本信息管理
 * @author wcy
 * @date 2019年1月2日15:14:16
 */
@Controller
@RequestMapping("apprec")
public class AppUpdRecordController extends AbstractController{
	@Autowired
	private AppUpdRecordService appUpdRecordService;

    @RequestMapping("/list")
    public String list() {
        return "apprec/list";
    }
	/**
	 * 列表
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("apprec:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        List<AppUpdRecord> commparaList = appUpdRecordService.queryList(query);
		int total = appUpdRecordService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(commparaList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}

}
