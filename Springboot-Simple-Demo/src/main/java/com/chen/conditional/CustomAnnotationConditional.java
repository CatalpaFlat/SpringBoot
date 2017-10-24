package com.chen.conditional;

import com.chen.conditional.annotation.ConditionalAnnotation;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义注解条件
 * @author 陈梓平
 * @date 2017/10/13.
 */
public class CustomAnnotationConditional extends SpringBootCondition{
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Object propertiesName = metadata.getAnnotationAttributes(ConditionalAnnotation.class.getName()).get("name");
        if (propertiesName != null) {
            String value = context.getEnvironment().getProperty(propertiesName.toString());
//            if (value != null) {
//            }
            return new ConditionOutcome(true, "get properties");
        }
        return new ConditionOutcome(false, "none get properties");

    }
}
