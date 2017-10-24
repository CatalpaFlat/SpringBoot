package com.chen.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 应用MVC模式配置适配器
 * Created by 陈梓平 on 2017/8/21.
 */
@Configuration 
public class IWebAppConfigurer extends WebMvcConfigurerAdapter {


    /**
     * 静态资源配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
        super.addResourceHandlers(registry);
    }


//    /**
//     * 连接器配置
//     * @param registry
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 多个拦截器组成一个拦截器链
//        // addPathPatterns 用于添加拦截规则
//        // excludePathPatterns 用户排除拦截
////        registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/hrm/**")
////                .excludePathPatterns("/hrm/acc/login","/hrm/acc/singOut","/js","/css","/images","/fonts","/oauth/token");
////        //拦截规则：除了login，其他都拦截判断
////        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**")
////                .excludePathPatterns("/hrm/acc/login","/hrm/acc/singOut","/js","/css","/images","/fonts","/oauth/token");
//        super.addInterceptors(registry);
//    }
}