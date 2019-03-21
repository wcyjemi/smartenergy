package xin.cymall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 系统页面视图
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2016年11月24日 下午11:05:27
 */
@Controller
public class SysPageController {
	@RequestMapping("{module}/{url}.html")
	public String page(@PathVariable("module") String module, @PathVariable("url") String url){
		return module + "/" + url + ".html";
	}


	@RequestMapping("index/main")
	public String main(Model model){
//		List<AppBaseInfo> appBaseInfoList = appBaseInfoService.queryList(new HashMap<String, Object>());
//		List<AppVersion> appVersionList = new ArrayList<>();
//		for (int i=0;i<appBaseInfoList.size();i++){
//			AppVersion temp = new AppVersion();
//			temp.setAppId(Long.parseLong(appBaseInfoList.get(i).getId()+""));
//			temp.setAppType("1");
//			AppVersion appVersion = appVersionService.queryLastAppVer(temp);
//			AppVersion temp2 = new AppVersion();
//			temp2.setAppId(Long.parseLong(appBaseInfoList.get(i).getId()+""));
//			temp2.setAppType("2");
//			AppVersion appVersion2 = appVersionService.queryLastAppVer(temp2);
//			if (appVersion!=null){
//				appVersionList.add(appVersion);
//			}
//			if (appVersion2!=null){
//				appVersionList.add(appVersion2);
//			}
//		}
//		model.addAttribute("appList",appVersionList);
//		return "main/index";
		return "menu/list";
	}

	@RequestMapping("index/map")
	public String mapPointChoose(Model model,String objId,String la,String lo){
		model.addAttribute("objId",objId);
		model.addAttribute("la",la);
		model.addAttribute("lo",lo);
		return "common/editmappoint";
	}

}
