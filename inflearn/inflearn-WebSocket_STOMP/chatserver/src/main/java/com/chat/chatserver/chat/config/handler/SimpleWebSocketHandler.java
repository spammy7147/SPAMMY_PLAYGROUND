package com.chat.chatserver.chat.config.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

//connect로 웹소켓 연결요청이 들어왔을때 이를 처리할 클래스
@Slf4j
//@Component
public class SimpleWebSocketHandler extends TextWebSocketHandler {

    //연결된 세션 관리: 쓰레드 safe한 set 사용
    private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        log.info("Connected : {}", session.getId());

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("received message : {}", payload);

        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                s.sendMessage(new TextMessage(payload));
            }
        }
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        log.info("disconnected");
    }
}
