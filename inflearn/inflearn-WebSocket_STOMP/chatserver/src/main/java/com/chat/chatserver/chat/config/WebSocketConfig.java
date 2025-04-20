package com.chat.chatserver.chat.config;

import com.chat.chatserver.chat.config.handler.SimpleWebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


//@Configuration
//@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private final SimpleWebSocketHandler simpleWebSocketHandler;

    public WebSocketConfig(SimpleWebSocketHandler simpleWebSocketHandler) {
        this.simpleWebSocketHandler = simpleWebSocketHandler;
    }

        /**
         * - connect url로 webSocket 연결 요청이 들어오면, 핸들러 클래스가 처리
         * - security config에서의 cors예외는 http 요청에 대한 예외
         * 따라서 websocket 프로토콜에 대한 요청은 별로의 cors 설정필요
         */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(simpleWebSocketHandler, "/connect")
                .setAllowedOrigins("http://localhost:3000");
    }
}
