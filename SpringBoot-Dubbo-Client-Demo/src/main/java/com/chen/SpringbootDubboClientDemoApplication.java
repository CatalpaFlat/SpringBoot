package com.chen;

import com.chen.dubbo.impl.DubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootDubboClientDemoApplication {
	@Autowired
	private DubboConsumerService dubboConsumerService;

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringbootDubboClientDemoApplication.class, args);
	}

	@GetMapping(value = "/get")
	public String ger(){
		return dubboConsumerService.get("fhuqio");
	}
}
