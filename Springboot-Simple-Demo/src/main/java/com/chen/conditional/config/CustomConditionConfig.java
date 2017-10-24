package com.chen.conditional.config;

import com.chen.conditional.CustomCondition;
import com.chen.conditional.TestCondition;
import com.chen.conditional.annotation.ConditionalAnnotation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author 陈梓平
 * @date 2017/10/13.
 */
@Configuration
public class CustomConditionConfig  {

    @Bean(value = "testCondition1")
    @Conditional(CustomCondition.class)//boot是启用@Conditional注解来确定是否要加载该实例
    public TestCondition testCondition1() {
        return new TestCondition();
    }
    @Bean(value = "testCondition2")
    @ConditionalAnnotation(name = "testCondition2")
    public TestCondition testCondition2() {
        return new TestCondition();
    }
}
