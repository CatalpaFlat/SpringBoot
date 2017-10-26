package com.chen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan(value = "com.chen.logic.mapper")
public class SpringbootLiveroomDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLiveroomDemoApplication.class, args);
	}
}
