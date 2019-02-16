package xin.cymall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.config.WebMvcConfig;
import xin.cymall.common.exception.MyException;
import xin.cymall.common.log.SysLog;
import xin.cymall.common.shiro.ShiroUtils;
import xin.cymall.common.utils.*;
import xin.cymall.entity.AppBaseInfo;
import xin.cymall.entity.AppUpdRecord;
import xin.cymall.entity.AppVersion;
import xin.cymall.entity.File;
import xin.cymall.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("appapi")
public class AppDataApiController extends AbstractController{
	@Autowired
	private AppVersionService appVersionService;
	@Autowired
	private SysConfigService sysConfigService;
	@Autowired
	private AppUpdRecordService appUpdRecordService;
	@Autowired
	private FileService fileService;

    /**
     * APP检测更新
     */
    @ResponseBody
    @RequestMapping("/checkApp")
	public R checkApp(@RequestBody String params, HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");//第一句，设置服务器端编码
        response.setContentType("application/json;charset=utf-8");//第二句，设置浏览器端解码
        JSONObject paramJson = JSON.parseObject(params);
        //用户ID
        String userId = paramJson.getString("userId");
        if (StringUtil.isNullOrEmpty(userId)){
            return R.error("用户ID不能为空");
        }
        //签名
        String sign = paramJson.getString("sign");
        if (StringUtil.isNullOrEmpty(sign)){
            return R.error("签名不能为空");
        }
        //应用ID
        String appId = paramJson.getString("appId");
        if (StringUtil.isNullOrEmpty(appId)){
            return R.error("应用ID不能为空");
        }
        //时间
        String time = paramJson.getString("time");
        if (StringUtil.isNullOrEmpty(time)){
            return R.error("时间不能为空");
        }
        //当前版本号
        String verNo = paramJson.getString("verNo");
        if (StringUtil.isNullOrEmpty(verNo)){
            return R.error("当前APP版本号不能为空");
        }
        //'app类型 1 Android 2 IOS'
        String appType = paramJson.getString("appType");
        if (StringUtil.isNullOrEmpty(appType)){
            return R.error("应用类型不能为空");
        }
        //验证签名
        String md5Sign = Md5Utils.md5(appId+userId+time+Constant.appKey,"UTF-8");
//        if (!md5Sign.equals(sign)){
//            return R.error("签名不正确");
//        }
        AppVersion appver = new AppVersion();
        appver.setAppId(Long.parseLong(appId));
        appver.setAppType(appType);
        Boolean isUpd = true;
        AppVersion appVersion = appVersionService.queryLastAppVer(appver);
        if (appVersion==null || verNo.equals(appVersion.getAppOutverno())){
            JSONObject jsonObject = new JSONObject();
            isUpd = false;
            return R.ok("已经是最新版本！").put("result",jsonObject).put("isUpd",isUpd);
        }
        return R.ok("有新版本！").put("result",appVersion).put("isUpd",isUpd);
    }

	/**
	 * APP更新开始接口
	 */
    @ResponseBody
	@RequestMapping("/checkUpdApp")
	public R checkUpdApp(@RequestBody String params, HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");//第一句，设置服务器端编码
        response.setContentType("application/json;charset=utf-8");//第二句，设置浏览器端解码
        JSONObject paramJson = JSON.parseObject(params);
        //用户ID
        String userId = paramJson.getString("userId");
        if (StringUtil.isNullOrEmpty(userId)){
            return R.error("用户ID不能为空");
        }
        //用户名称
        String userName = paramJson.getString("userName");
        if (StringUtil.isNullOrEmpty(userName)){
            return R.error("用户名称不能为空");
        }
        //用户请求IP
        String ip = IPUtils.getIpAddr(request);
        if (StringUtil.isNullOrEmpty(ip)){
            return R.error("请求IP不能为空");
        }
        //签名
        String sign = paramJson.getString("sign");
        if (StringUtil.isNullOrEmpty(sign)){
            return R.error("签名不能为空");
        }
        //手机类型
        String mobileType = paramJson.getString("mobileType");
        if (StringUtil.isNullOrEmpty(mobileType)){
            return R.error("手机类型不能为空");
        }
        //手机物理地址
        String pyAddress = paramJson.getString("pyAddress");
        if (StringUtil.isNullOrEmpty(pyAddress)){
            return R.error("手机物理地址不能为空");
        }
        //时间
        String time = paramJson.getString("time");
        if (StringUtil.isNullOrEmpty(time)){
            return R.error("时间不能为空");
        }
        //应用ID
        String appId = paramJson.getString("appId");
        if (StringUtil.isNullOrEmpty(appId)){
            return R.error("应用ID不能为空");
        }
        //当前版本号
        String verNo = paramJson.getString("verNo");
        if (StringUtil.isNullOrEmpty(verNo)){
            return R.error("当前APP版本号不能为空");
        }
        //'app类型 1 Android 2 IOS'
        String appType = paramJson.getString("appType");
        if (StringUtil.isNullOrEmpty(appType)){
            return R.error("应用类型不能为空");
        }
        //验证签名
        String md5Sign = Md5Utils.md5(appId+userId+time+Constant.appKey,"UTF-8");
//        if (!md5Sign.equals(sign)){
//            return R.error("签名不正确");
//        }

        AppVersion appver = new AppVersion();
        appver.setAppId(Long.parseLong(appId));
        appver.setAppType(appType);
        AppVersion appVersion = appVersionService.queryLastAppVer(appver);
        if (appVersion==null || verNo.equals(appVersion.getAppOutverno())){
            return R.ok("已经是最新版本！").put("result","");
        }

        WebMvcConfig.updUserCount++;
        //获取允许同时下载人数
        Integer configUserCount = 10;
        try {
            configUserCount = Integer.parseInt(sysConfigService.getValue("onlineUserCount","10"));
        }catch (Exception e){
            e.printStackTrace();
            configUserCount = 10;
        }
        if (WebMvcConfig.updUserCount>configUserCount){
            if (WebMvcConfig.updUserCount>0){
                WebMvcConfig.updUserCount--;
            }
            return R.error("当前下载人数过多，请稍后重试！").put("code","10");
        }

        AppUpdRecord appUpdRecord = new AppUpdRecord();
        appUpdRecord.setAppId(Long.parseLong(appId));
        appUpdRecord.setAppName(appVersion.getAppName());
        appUpdRecord.setAppInnerverno(appVersion.getAppInnerverno());
        appUpdRecord.setAppOutverno(appVersion.getAppOutverno());
        List<File> appVerFiles = fileService.getByRelationId(appVersion.getAppUrl());
        appUpdRecord.setAppDownurl(WebMvcConfig.propMap.get("file_url_root")+appVerFiles.get(0).getUrl());
        appUpdRecord.setAppType(appType);
        appUpdRecord.setDownUser(userId);
        appUpdRecord.setDownUsername(userName);
        appUpdRecord.setMobileType(mobileType);
        appUpdRecord.setIpAddr(ip);
        appUpdRecord.setPyAddr(pyAddress);
        appUpdRecordService.save(appUpdRecord);
        appVersionService.updDownCount(appVersion.getId());
        Map<String,String> result = new HashMap<>();
        result.put("appDownUrl",appUpdRecord.getAppDownurl());
		return R.ok("获取数据成功").put("result", result);
	}

    /**
     * APP更新开始接口
     */
    @ResponseBody
    @RequestMapping("/downFinishNotify")
	public R downFinishNotify(@RequestBody String params, HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");//第一句，设置服务器端编码
        response.setContentType("application/json;charset=utf-8");//第二句，设置浏览器端解码
        JSONObject paramJson = JSON.parseObject(params);
        //用户ID
        String userId = paramJson.getString("userId");
        if (StringUtil.isNullOrEmpty(userId)){
            return R.error("用户ID不能为空");
        }
        //签名
        String sign = paramJson.getString("sign");
        if (StringUtil.isNullOrEmpty(sign)){
            return R.error("签名不能为空");
        }
        //应用ID
        String appId = paramJson.getString("appId");
        if (StringUtil.isNullOrEmpty(appId)){
            return R.error("应用ID不能为空");
        }
        //时间
        String time = paramJson.getString("time");
        if (StringUtil.isNullOrEmpty(time)){
            return R.error("时间不能为空");
        }
        //验证签名
        String md5Sign = Md5Utils.md5(appId+userId+time+Constant.appKey,"UTF-8");
//        if (!md5Sign.equals(sign)){
//            return R.error("签名不正确");
//        }
        if (WebMvcConfig.updUserCount>0){
            WebMvcConfig.updUserCount--;
        }
        return R.ok("通知完成");
    }

    @ResponseBody
    @RequestMapping("/getOnlineCount")
    public R getOnlineCount(){
        return R.ok().put("onlineCount",WebMvcConfig.updUserCount);
    }

    @ResponseBody
    @RequestMapping("/adminClearCount")
    public R adminClearCount(){
        if (WebMvcConfig.updUserCount>0){
            WebMvcConfig.updUserCount--;
        }
        return R.ok("通知完成");
    }


}
