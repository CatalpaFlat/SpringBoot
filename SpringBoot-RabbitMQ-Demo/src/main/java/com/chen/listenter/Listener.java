package com.chen.listenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;
import com.chen.config.RabbitMQConfig;
/**
 * @author 陈梓平
 * @date 2017/10/25.
 */
@Configuration
@RabbitListener(queues = RabbitMQConfig.FOO_EXCHANGE)
public class Listener {
    private static final Logger log = LoggerFactory.getLogger(Listener.class);
    /** 设置交换机类型  */
    @Bean
    public DirectExchange defaultExchange() {
        /**
         * DirectExchange:按照routingkey分发到指定队列
         * TopicExchange:多关键字匹配
         * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
         * HeadersExchange ：通过添加属性key-value匹配
         */
        return new DirectExchange(RabbitMQConfig.FOO_EXCHANGE);
    }
    @Bean
    public Binding binding() {
        /** 将队列绑定到交换机 */
        return BindingBuilder.bind(fooQueue()).to(defaultExchange()).with(RabbitMQConfig.FOO_ROUTINGKEY);
    }
    @Bean
    public Queue fooQueue() {
        return new Queue(RabbitMQConfig.FOO_EXCHANGE);
    }
    @RabbitHandler
    public void process(@Payload String foo) {
        log.info("Listener: " + foo);
    }
}
