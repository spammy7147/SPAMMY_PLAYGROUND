package com.chat.chatserver.chat.repository;

import com.chat.chatserver.chat.domain.ChatParticipant;
import com.chat.chatserver.chat.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    List<ChatRoom> isGroupChat(String isGroupChat);

    List<ChatRoom> findByIsGroupChat(String isGroupChat);

    List<ChatRoom> findByChatParticipantsAndIsGroupChat(List<ChatParticipant> chatParticipants, String isGroupChat);
}
