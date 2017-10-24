package com.chen.conditional.annotation;

import com.chen.conditional.CustomAnnotationConditional;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author 陈梓平
 * @date 2017/10/13.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(CustomAnnotationConditional.class)
public @interface ConditionalAnnotation {
    String name();
}
