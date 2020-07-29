package com.young.easyexcel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @author young
 */
@SpringBootApplication
@MapperScan("com.young.easyexcel.mapper")
public class EasyexcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyexcelApplication.class, args);
	}

	/**
	 * 文件上传配置
	 *
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//文件最大
		//KB,MB
		factory.setMaxFileSize(DataSize.parse("1024000KB"));
		/// 设置总上传数据总大小
		factory.setMaxRequestSize(DataSize.parse("1024000KB"));
		return factory.createMultipartConfig();
	}
}
