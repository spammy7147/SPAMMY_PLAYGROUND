package com.chat.chatserver.chat.config.handler;

import com.chat.chatserver.chat.service.ChatService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StompHandler implements ChannelInterceptor {
    @Value("${jwt.secretKey}")
    private String secretKey;

    private final ChatService chatService;

    public StompHandler(ChatService chatService) {
        this.chatService = chatService;
    }


    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        log.info("message = {}", message);
        log.info("channel = {}", channel);
        
        final StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);


        if (StompCommand.CONNECT == accessor.getCommand()) {
            log.info("connect요청시 토큰 유효성 검증 시작");
            String bearerToken = accessor.getFirstNativeHeader("Authorization");
            String token = bearerToken.substring(7);

            //토큰 검증 및 claims 추출
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            log.info("claims = {}", claims);
            log.info("connect 토큰검증 완료");
        }

        if (StompCommand.SUBSCRIBE == accessor.getCommand()) {
            log.info("subscribe 검증");
            String bearerToken = accessor.getFirstNativeHeader("Authorization");
            String token = bearerToken.substring(7);

            //토큰 검증 및 claims 추출
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String email = claims.getSubject();
            String roomId = accessor.getDestination().split("/")[2];
            if(chatService.isRoomParticipant(email, Long.parseLong(roomId))) {
                throw new AuthenticationServiceException("해당 room에 권한이 없습니다.");
            }

            log.info("claims = {}", claims);
            log.info("subscribe 토큰검증 완료");
        }
        return ChannelInterceptor.super.preSend(message, channel);
    }
}
