package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:providers.xml"}) // 使用 providers.xml 配置；
public class SpringbootZookeeperDubboApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootZookeeperDubboApplication.class, args);
	}
}
