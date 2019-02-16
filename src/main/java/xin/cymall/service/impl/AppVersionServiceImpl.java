package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.cymall.common.config.WebMvcConfig;
import xin.cymall.common.utils.FileUtil;
import xin.cymall.common.utils.QRCodeUtil;
import xin.cymall.dao.AppVersionDao;
import xin.cymall.dao.FileDao;
import xin.cymall.entity.AppVersion;
import xin.cymall.entity.File;
import xin.cymall.service.AppVersionService;
import xin.cymall.service.FileService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service("appVersionService")
@Transactional
public class AppVersionServiceImpl implements AppVersionService {
	@Autowired
	private AppVersionDao appVersionDao;
	@Autowired
	private FileService fileService;

	@Override
	public List<AppVersion> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return appVersionDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return appVersionDao.queryTotal(map);
	}

	@Override
	public List<AppVersion> findByVerify(AppVersion appVersion) {
		// TODO Auto-generated method stub
		return appVersionDao.findByVerify(appVersion);
	}

	@Override
	public void save(AppVersion appVersion){
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateDir = dateFormat.format(new Date());

		String pyPath = WebMvcConfig.propMap.get("physical_dir")+appVersion.getAppEnname()+"_Qr"+"/"+dateDir+"/";//获取文件存储物理路径
		java.io.File file = new java.io.File(pyPath);
		if (!file.exists()){
			file.mkdirs();
		}
		String netPath = WebMvcConfig.propMap.get("network_url");
		netPath = netPath.substring(0, netPath.lastIndexOf("/"))+"/"+appVersion.getAppEnname()+"_Qr"+"/"+dateDir+"/";
		String qrFileName = System.currentTimeMillis()+".jpg";
		List<File> appVerFiles = fileService.getByRelationId(appVersion.getAppUrl());
		QRCodeUtil.zxingCodeCreate(WebMvcConfig.propMap.get("file_url_root")+appVerFiles.get(0).getUrl(),180,180,pyPath+qrFileName,"jpg");

		//生成二维码
		File uploadFile = new File();
		uploadFile.setUploadId(UUID.randomUUID().toString());
		uploadFile.setFileName(qrFileName);
		uploadFile.setFileSize("100");
		uploadFile.setCreateTime(new Date());
		uploadFile.setUrl(netPath+qrFileName);
		//获取文件类型
		boolean isPicture = false;
		try {
			isPicture = FileUtil.isPicture(qrFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isPicture) {
			uploadFile.setFileType("image");
		} else {
			uploadFile.setFileType(".jpg");
		}
		fileService.save(uploadFile);

		appVersion.setAppQr(uploadFile.getUploadId());
		appVersionDao.save(appVersion);

	}

	@Override
	public AppVersion queryObject(Integer id) {
		// TODO Auto-generated method stub
		return appVersionDao.queryObject(id);
	}

	@Override
	public AppVersion queryLastAppVer(AppVersion appVersion) {
		return appVersionDao.queryLastAppVer(appVersion);
	}

	@Override
	public void update(AppVersion appVersion) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateDir = dateFormat.format(new Date());

		String pyPath = WebMvcConfig.propMap.get("physical_dir")+appVersion.getAppEnname()+"_Qr"+"/"+dateDir+"/";//获取文件存储物理路径
		java.io.File file = new java.io.File(pyPath);
		if (!file.exists()){
			file.mkdirs();
		}
		String netPath = WebMvcConfig.propMap.get("network_url");
		netPath = netPath.substring(0, netPath.lastIndexOf("/"))+"/"+appVersion.getAppEnname()+"_Qr"+"/"+dateDir+"/";
		String qrFileName = System.currentTimeMillis()+".jpg";
		List<File> appVerFiles = fileService.getByRelationId(appVersion.getAppUrl());
		QRCodeUtil.zxingCodeCreate(WebMvcConfig.propMap.get("file_url_root")+appVerFiles.get(0).getUrl(),180,180,pyPath+qrFileName,"jpg");

		//生成二维码
		File uploadFile = new File();
		uploadFile.setUploadId(UUID.randomUUID().toString());
		uploadFile.setFileName(qrFileName);
		uploadFile.setFileSize("100");
		uploadFile.setCreateTime(new Date());
		uploadFile.setUrl(netPath+qrFileName);
		//获取文件类型
		boolean isPicture = false;
		try {
			isPicture = FileUtil.isPicture(qrFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isPicture) {
			uploadFile.setFileType("image");
		} else {
			uploadFile.setFileType(".jpg");
		}
		fileService.save(uploadFile);

		appVersion.setAppQr(uploadFile.getUploadId());

		appVersionDao.update(appVersion);
	}

	@Override
	public void updateBatch(Integer[] ids, String stateValue) {
		// TODO Auto-generated method stub
		appVersionDao.updateStatusBatch(ids, stateValue);
	}

	/**
	 * 更新下载次数
	 */
	@Override
	public void updDownCount(Long id) {
		appVersionDao.updDownCount(id);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		// TODO Auto-generated method stub
		appVersionDao.deleteBatch(ids);
	}
	

}
