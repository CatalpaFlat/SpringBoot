package com.chen;

import com.chen.conditional.TestCondition;
import com.chen.enable.entity.POJOToProperties;
import com.chen.listener.event.CustomApplicationEvent;
import com.chen.runner.StartRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties(POJOToProperties.class)//注入从配置文件读取的POJO类
//@EnableScheduling//注解@Scheduled的任务并后台执行,Springboot本身默认的执行方式是串行执行，也就是说无论有多少task，都是一个线程串行执行，并行需手动配置
//@EnableAsync//注解的意思是可以异步执行，就是开启多线程的意思。可以标注在方法、类上
public class SpringbootSimpleDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootSimpleDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringbootSimpleDemoApplication.class);
		//使用场景：
		/*
		* 在一些业务场景中，当容器初始化完成之后，需要处理一些操作，
		* 比如一些数据的加载、初始化缓存、特定任务的注册等等。
		* 这个时候我们就可以使用Spring提供的ApplicationListener来进行操作。
		* */
		//第一种实现事件监听方法
//			//在启动类中配置配置事件监听器
//			application.addListeners(new CustomApplicationListener());
		//第二种添加上@Component注解，纳入spring容器管理
		//第三种在配置文件中配置context.listener.classes=包名+类名
		/*第四中第四种方法，
		 * 1、自定义CustomEventHandle
		 * 2、使用@EventListener注解
		 * 3、并且纳入Spring容器中
		 */




		ConfigurableApplicationContext context =application.run(args);
		//发布事件
		context.publishEvent(new CustomApplicationEvent(new Object()));


		TestCondition bean = (TestCondition)context.getBean("testCondition2");
		bean.print();
//		context.close();

		logger.info("Application start success!");

	}

	/**
	 * Command line runners的使用场景
	 * 对于那种只需要在应用程序启动时执行一次的任务，非常适合利用Command line runners来完成
	 * 利用command-line runner的这个特性，再配合依赖注入，可以在应用程序启动时后首先引入一些依赖bean，
	 * 例如data source、rpc服务或者其他模块等等，这些对象的初始化可以放在run方法中。
	 * 不过，需要注意的是，在run方法中执行初始化动作的时候一旦遇到任何异常，都会使得应用程序停止运行，
	 * 因此最好利用try/catch语句处理可能遇到的异常。
	 * @return
	 */
	@Bean
	public StartRunner startRunner(){
		return  new StartRunner();
	}

}
