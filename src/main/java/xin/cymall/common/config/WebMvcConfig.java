package xin.cymall.common.config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 图片绝对地址与虚拟地址映射
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Value("${physical_dir}")
	private String physicalDir;
	
	@Value("${network_url}")
	private String networkUrl;
	@Value("${file_url_root}")
	private String fileUrlRoot;
	
	public static Map<String, String> propMap = new HashMap<String, String>();

	public static Integer updUserCount = 0;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 文件磁盘图片url 映射
		// 配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
		System.out.println(physicalDir + "---" + networkUrl);
		File file = new File(physicalDir);
		if (!file.exists()) {
			file.mkdir();
		}
		propMap.put("physical_dir", physicalDir);
		propMap.put("network_url", networkUrl);
		propMap.put("file_url_root", fileUrlRoot);
		registry.addResourceHandler(networkUrl).addResourceLocations("file:"+physicalDir);
	}
}
