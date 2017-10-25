package com.chen;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRabbitmqDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootRabbitmqDemoApplication.class, args);
		LoggerFactory.getLogger(SpringbootRabbitmqDemoApplication.class).info("SpringBoost is start....");
	}
}
