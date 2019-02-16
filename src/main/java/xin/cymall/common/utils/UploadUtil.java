package xin.cymall.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import xin.cymall.common.config.UploadDirConfig;
import xin.cymall.common.config.WebMvcConfig;

/**
 * Created by wcy
 * 2017/7/29.
 */
public class UploadUtil {

//    public static String  uploadImage(String fileName, InputStream inputStream) {
//        String fileNameBak=fileName;
//        String resultImgUrl ="";
//        String endpoint ="";
//        String accessKeyId = "";
//        String accessKeySecret = "";
//        String bucket = "";
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//        if (!ossClient.doesBucketExist(bucket)) {
//            ossClient.createBucket(bucket);
//        }
//
//        ObjectMetadata objectMeta = new ObjectMetadata();//oss属性设置
//        //objectMeta.setContentLength(inputStream.getSize());//标记长度
//        objectMeta.setContentType("image/jpeg");// 可以在metadata中标记文件类型
//        try {
//
//            //获取上传的图片文件名
//            Long nanoTime = System.nanoTime();// 防止文件被覆盖，以纳秒生成图片名
//            String _extName = fileName.substring(fileName.indexOf("."));//获取扩展名
//            fileName = nanoTime + _extName;
//            fileName = DateUtil.getYmd()+"/"+fileName+"/"+fileNameBak;
//            ossClient.putObject(bucket,fileName, inputStream,objectMeta);
//            resultImgUrl+=fileName;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new MyException("上传失败");
//        }finally{
//            ossClient.shutdown();
//        }
//        return resultImgUrl;
//    }
	
	public static String uploadFile(String fileName,InputStream in,String fileDir){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateDir = dateFormat.format(new Date());
		
		String pyPath = WebMvcConfig.propMap.get("physical_dir")+fileDir+"/"+dateDir+"/";//获取文件存储物理路径
		File pyPathFile = new File(pyPath);
		if (!pyPathFile.exists()) {
			pyPathFile.mkdirs();
		}
		
		String urlPath = WebMvcConfig.propMap.get("network_url");//获取文件存储映射网络路径
		
		long now = System.currentTimeMillis();
		String extName = fileName.substring(fileName.lastIndexOf("."));
		String trueFileName = fileName.substring(0, fileName.lastIndexOf("."))+now+extName;
		FileOutputStream outPut = null;
        File file = new File(pyPath+trueFileName);
        try {
        	file.createNewFile();
			outPut = new FileOutputStream(file);
			byte temp[] = new byte[1024];
	        int size = -1;
	        while ((size = in.read(temp)) != -1) { // 每次读取1KB，直至读完
	        	outPut.write(temp, 0, size);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        urlPath = urlPath.substring(0, urlPath.lastIndexOf("/"))+"/"+fileDir+"/"+dateDir+"/"+trueFileName;
		
		return urlPath;
	}
}
