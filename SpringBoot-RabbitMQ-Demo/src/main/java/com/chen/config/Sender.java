package com.chen.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 发布者
 * @author 陈梓平
 * @date 2017/10/25.
 */
@Component
public class Sender implements RabbitTemplate.ConfirmCallback{

    private static final Logger log = LoggerFactory.getLogger(Sender.class);

    private RabbitTemplate  rabbitTemplate;

    @Autowired
    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(this);
    }
    /**
     * 发送消息
     * @param content
     */
    public void sendMsg(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitMQConfig.CHEN_EXCHANGE, RabbitMQConfig.CHEN_ROUTINGKEY,
                content, correlationId);
//        rabbitTemplate.convertAndSend("CEHN",content);
    }

    /**
     * 发布消息后进行回调
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调id:" + correlationData);
        if (ack) {
            log.info("消息成功消费");
        } else {
            log.info("消息消费失败:" + cause);
        }
    }
}
