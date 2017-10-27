package com.chen.config;

import com.chen.module.inceptor.HandShkeInceptor;
import com.chen.module.inceptor.InboundChannelInceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author 陈梓平
 * @date 2017/10/25.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //添加访问域名限制可以防止跨域socket连接
        //setAllowedOrigins("http://localhost:8085")
        stompEndpointRegistry.addEndpoint("/live").setAllowedOrigins("*").
                addInterceptors(new HandShkeInceptor()).withSockJS();
    }

    /**
     * 配置消息代理rabitMQ
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //假如需要第三方消息代理，比如rabitMQ,activeMq，在这里配置
        registry.setApplicationDestinationPrefixes("/demo")
                .enableStompBrokerRelay("/topic","/house")//设置stomp协议传递者
                .setRelayHost("127.0.0.1")
                .setRelayPort(61613)
                .setClientLogin("guest")
                .setClientPasscode("guest")
                .setSystemLogin("guest")
                .setSystemPasscode("guest")
                .setSystemHeartbeatSendInterval(5000)//设置系统发送间隔
                .setSystemHeartbeatReceiveInterval(4000);//设置系统接收间隔

        registry.setUserDestinationPrefix("/house");
    }

    /**
     * 配置客户端入站通道
     * @param registration
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        super.configureClientInboundChannel(registration.interceptors(new InboundChannelInceptor()));
    }

    /**
     * 配置客户端出站通道
     * @param registration
     */
    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        super.configureClientOutboundChannel(registration);
    }
}
