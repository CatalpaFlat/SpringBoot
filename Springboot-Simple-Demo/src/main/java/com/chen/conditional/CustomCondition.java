package com.chen.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义条件
 * spring-boot利用Conditional来确定是不是要创建Bean实例，
 * boot是启用@Conditional注解来确定是否要加载该实例
 * @author 陈梓平
 * @date 2017/10/13.
 */
public class CustomCondition implements Condition {
    /**
     * 条件校验
     * @param conditionContext 条件上下文
     * @param annotatedTypeMetadata 注释类型的元数据
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Class<? extends Environment> aClass = conditionContext.getEnvironment().getClass();
        String name = aClass.getName();
//        if (name.contains("TestCondition"))
            return true;
//        else
//            return false;
    }
}
