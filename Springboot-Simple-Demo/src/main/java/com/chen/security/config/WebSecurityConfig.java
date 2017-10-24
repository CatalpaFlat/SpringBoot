package com.chen.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 配置web安全
 * @author 陈梓平
 * @date 2017/10/16.
 */
//@Configuration
//@EnableWebSecurity//注解开启Spring Security的功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/","home")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
            .formLogin()//定义当需要用户登录时候，转到的登录页面
                .loginPage("/login")
                .permitAll()
                .and().
            logout().
                permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中创建了一个用户
        auth.inMemoryAuthentication()
                .withUser("admin")//用户的名称
                .password("123456")//密码
                .roles("USER");//用户角色
    }
}
