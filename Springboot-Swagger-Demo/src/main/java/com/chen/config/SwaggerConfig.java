package com.chen.config;

import com.google.common.base.Predicate;
import io.swagger.models.Contact;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger配置
 * @author 陈梓平
 * @date 2017/10/24.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket demoApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")//组名
                .genericModelSubstitutes(DeferredResult.class)//通用的模板替代
                .useDefaultResponseMessages(false)//是否使用默认响应信息
                .forCodeGeneration(true)//通用编码
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(or(regex("/api/.*")))//过滤的接口
                .build()
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        Contact contact = new  Contact();
        contact.setName("陈梓平");
        contact.setUrl("http://blog.csdn.net/dushiwodecuo");
        contact.setEmail("1013427541@qq.com");
        return new ApiInfoBuilder()
                .title("Electronic Health Record(EHR) Platform API")//大标题
                .description("EHR Platform's REST API, all the applications could access the Object model data via JSON.")//详细描述
                .version("1.0")//版本
                .termsOfServiceUrl("NO terms of service")
                .contact("陈梓平")//作者
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {

            @Override
            public boolean apply(RequestHandler requestHandler) {
                Class<?> declaringClass  = requestHandler.getClass();
                if (declaringClass == BasicErrorController.class)// 排除
                    return false;
                if(declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
                    return true;
                if(declaringClass.isAssignableFrom(ResponseBody.class)) // 被注解的方法
                    return true;
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(predicate)
                .build();
    }
}
