package com.chat.chatserver.chat.controller;

import com.chat.chatserver.chat.dto.ChatMessageReqDto;
import com.chat.chatserver.chat.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;


/**
 * 방법1: MessageMapping(수신)과 SendTo(topic에 메세지 전달) 한꺼번에 처리
 * 방법2: MessageMapping어노테이션만 사용
 */
@Slf4j
@Controller
public class StompController {

    private final SimpMessageSendingOperations messageTemplate;
    private final ChatService chatService;

    public StompController(SimpMessageSendingOperations messageTemplate, ChatService chatService) {
        this.messageTemplate = messageTemplate;
        this.chatService = chatService;
    }

    /**
     * DestinationVariable : @MessageMapping 어노테이션으로 정의된 WebSocket Controller 내에서만 사용된다
     * @MessageMapping("{roomId}") 클라이언트에서 특정 publish/{roomId} 형태로 메세지 발생시 MessageMapping 에서 수신
     * @SendTo("/topic/{roomId}" 해당 roomId에 메세지를 발행하여 구독중인 클라이언트에게 메세지 전송 
     */
//    @MessageMapping("{roomId}")
//    @SendTo("/topic/{roomId}")
    public String sendMessageV1(@DestinationVariable Long roomId, String message) {
        log.info("message = {}", message);
        return message;
    }

    @MessageMapping("{roomId}")
    @SendTo("/topic/{roomId}")
    public void sendMessageV2(@DestinationVariable Long roomId, ChatMessageReqDto chatMessageReqDto) {
        log.info("message = {}", chatMessageReqDto.getMessage());
        chatService.saveMessage(roomId, chatMessageReqDto);
        messageTemplate.convertAndSend("/topic/" + roomId, chatMessageReqDto);
    }
}
