package com.chat.chatserver.chat.controller;

import com.chat.chatserver.chat.dto.ChatMessageDto;
import com.chat.chatserver.chat.dto.ChatRoomResDto;
import com.chat.chatserver.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    //그룹채팅방 개설
    @PostMapping("/room/group/create")
    public ResponseEntity<?> createGroupRoom(@RequestParam String roomName) {
        chatService.createGroupRoom(roomName);
        return ResponseEntity.ok().build();
    }

    //그룹채팅 목록조회
    @GetMapping("/room/group/list")
    public ResponseEntity<?> getGroupChatRooms() {
        List<ChatRoomResDto> chatRooms = chatService.getGroupChatRooms();
        return new ResponseEntity<>(chatRooms, HttpStatus.OK);
    }

    //그룹채팅방 참여
    @PostMapping("/room/group/{roomId}/join")
    public ResponseEntity<?> joinGroupChatRoom(@PathVariable Long roomId) {
        chatService.addParticipantToGroupChat(roomId);
        return ResponseEntity.ok().build();
    }

    //이전메세지조회
    @GetMapping("/history/{roomId}")
    public ResponseEntity<?> getChatHistory(@PathVariable Long roomId) {
        List<ChatMessageDto> chatMessageDtos = chatService.getChatHistory(roomId);
        return new ResponseEntity<>(chatMessageDtos, HttpStatus.OK);
    }
}
