package com.chen.module.inceptor;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 通过握手拦截器判断用户是否登录
 * @author 陈梓平
 * @date 2017/10/26.
 */
public class HandShkeInceptor extends HttpSessionHandshakeInterceptor {

    private static final Logger log = LoggerFactory.getLogger(HandShkeInceptor.class);

    @Override
    public boolean beforeHandshake(ServerHttpRequest servletRequest, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        log.info("begin handsh....");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        String id =session.getId();
        String attribute = (String) session.getAttribute(id);
        if (StringUtils.isBlank(attribute)){
            log.error("is no login!");
            return false;
        }else {
            log.info("is login");
            return true;
        }
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        //握手成功后，通常用来注册用户信息
        log.info("end handsh....");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
