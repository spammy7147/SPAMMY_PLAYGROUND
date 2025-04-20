package com.chat.chatserver.chat.config;

import com.chat.chatserver.chat.config.handler.StompHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final StompHandler stompHandler;

    public StompWebSocketConfig(StompHandler stompHandler) {
        this.stompHandler = stompHandler;
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /**
         * ws:// 가 아닌 http:// 앤드포인트를 사용할 수 있게 해주는 sockJs라이브러리를 통한 요청을 허용하는 설정
         */
        registry.addEndpoint("/connect")
                .setAllowedOrigins("http://localhost:3000")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /**
         * /publish/1 형태로 메세지를 발행해야 함을 설정
         * /topic/1 형태로 메세지를 수신(subscribe) 해야됨
         *
         *  /publish로 시작하는 url패턴으로 메세지가 발행되면 @Controller 객체의 @MessageMapping 메서드로 라우팅된다
         */
        registry.setApplicationDestinationPrefixes("/publish")
                .enableSimpleBroker("/topic");
    }

    /**
     * 웹소켓요청(connect, subscribe, disconnect)등의 요청시에는 http header등 http메세지를 넣을 수 있고
     * 이를 interceptor를 통해 가로채 토큰등을 검증 할 수 있음
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(stompHandler);
    }
}
