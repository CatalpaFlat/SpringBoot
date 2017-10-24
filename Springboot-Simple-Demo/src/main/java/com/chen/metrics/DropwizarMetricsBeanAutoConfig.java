package com.chen.metrics;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.management.MBeanServer;

/**
 * 将AOP逻辑暴露配置
 * @author 陈梓平
 * @date 2017/10/16.
 */
@Configuration
//将两个java package下的所有组件都架子啊到IoC容器中（如：AOP和Dropwizard Metrics）
@ComponentScan({"com.chen.metrics.aop","com.chen.metrics.lifecycle"})
@AutoConfigureAfter(AopAutoConfiguration.class)
public class DropwizarMetricsBeanAutoConfig {
    //开发配置属性，自定义的Mbean暴露和访问命名空间
    @Value(
            "${metrics.mbenas.domain.name:com.chen.metrics}"
    )
    String metricsBeansDomainName;

    @Autowired
    MBeanServer mBeanServer;

    @Autowired
    MetricRegistry metricRegistry;


    //性能指标
    @Bean
    public JmxReporter jmxReporter(){
        JmxReporter reporter = JmxReporter
                .forRegistry(metricRegistry)
                .inDomain(metricsBeansDomainName)
                .registerWith(mBeanServer)
                .build();
        return reporter;
    }

}
