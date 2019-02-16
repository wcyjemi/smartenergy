package xin.cymall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("xin.cymall.dao")
// 启用缓存注解
@EnableCaching
public class CyFastApplication {

	public static void main(String[] args) {
		SpringApplication.run(CyFastApplication.class, args);
	}
}
