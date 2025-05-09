package com.chat.chatserver.chat.service;

import com.chat.chatserver.chat.domain.ChatMessage;
import com.chat.chatserver.chat.domain.ChatParticipant;
import com.chat.chatserver.chat.domain.ChatRoom;
import com.chat.chatserver.chat.domain.ReadStatus;
import com.chat.chatserver.chat.dto.ChatMessageDto;
import com.chat.chatserver.chat.dto.ChatRoomResDto;
import com.chat.chatserver.chat.dto.MyChatListResDto;
import com.chat.chatserver.chat.repository.ChatMessageRepository;
import com.chat.chatserver.chat.repository.ChatParticipantRepository;
import com.chat.chatserver.chat.repository.ChatRoomRepository;
import com.chat.chatserver.chat.repository.ReadStatusRepository;
import com.chat.chatserver.member.domain.Member;
import com.chat.chatserver.member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatService {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatParticipantRepository chatParticipantRepository;
    private final ReadStatusRepository readStatusRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void saveMessage(Long roomId, ChatMessageDto chatMessageReqDto) {
        //채팅방 조회
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).orElseThrow(()-> new EntityNotFoundException("room cannot be found"));

        //보낸사람 조회
        Member sender = memberRepository.findByEmail(chatMessageReqDto.getSenderEmail()).orElseThrow(() -> new EntityNotFoundException("member cannot be found"));

        //메세지 저장
        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoom)
                .member(sender)
                .content(chatMessageReqDto.getMessage())
                .build();
        chatMessageRepository.save(chatMessage);

        // 사용자별로 읽음여부 저장
        List<ChatParticipant> chatParticipants = chatParticipantRepository.findByChatRoom(chatRoom);

        for (ChatParticipant chatParticipant : chatParticipants) {
            ReadStatus readStatus = ReadStatus.builder()
                    .chatRoom(chatRoom)
                    .member(chatParticipant.getMember())
                    .chatMessage(chatMessage)
                    .isRead(chatParticipant.getMember().equals(sender))
                    .build();
            readStatusRepository.save(readStatus);
        }



    }

    @Transactional
    public void createGroupRoom(String roomName) {
        Member member = memberRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new EntityNotFoundException("member cannot be found"));

        //채팅방 생성
        ChatRoom chatRoom = ChatRoom.builder()
                .name(roomName)
                .isGroupChat("Y")
                .build();

        chatRoomRepository.save(chatRoom);

        //채팅참여자로 개설자를 추가
        ChatParticipant chatParticipant = ChatParticipant.builder()
                .chatRoom(chatRoom)
                .member(member)
                .build();

        chatParticipantRepository.save(chatParticipant);

    }

    public List<ChatRoomResDto> getGroupChatRooms() {
        List<ChatRoom> chatRooms = chatRoomRepository.findByIsGroupChat("Y");
        return chatRooms.stream().map(el -> ChatRoomResDto.builder().roomId(el.getId()).roomName(el.getName()).build()).collect(Collectors.toList());
    }

    @Transactional
    public void addParticipantToGroupChat(Long roomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException("room cannot be found"));
        Member member = memberRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new EntityNotFoundException("member cannot found"));

        if (chatRoom.getIsGroupChat().equals("N")) {
            throw new IllegalArgumentException("그룹 채팅이 아닙니다");
        }

        Optional<ChatParticipant> participant = chatParticipantRepository.findByChatRoomAndMember(chatRoom, member);
        if (!participant.isPresent()) {
            addParticipantToRoom(chatRoom, member);
        }
    }

    public void addParticipantToRoom(ChatRoom chatRoom, Member member) {
        chatParticipantRepository.save(ChatParticipant.builder()
                .chatRoom(chatRoom)
                .member(member)
                .build());
    }

    public List<ChatMessageDto> getChatHistory(Long roomId) {
        //해당 채팅방에 참여자가 아닐경우 에러
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException("room cannot be found"));
        Member member = memberRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new EntityNotFoundException("member cannot found"));

        List<ChatParticipant> chatParticipants = chatRoom.getChatParticipants();
        chatParticipants.stream()
                .filter(el -> el.getMember().equals(member))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("본인이 속하지 않은 채팅방입니다."));

        //특정 room에 대한 message 조회
        List<ChatMessage> chatMessages = chatMessageRepository.findByChatRoomOrderByCreatedTimeAsc(chatRoom);
        return chatMessages.stream()
                .map(el -> ChatMessageDto.builder()
                        .senderEmail(el.getMember().getEmail())
                        .message(el.getContent())
                        .build())
                .collect(Collectors.toList());
    }

    public boolean isRoomParticipant(String email, Long roomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException("room cannot be found"));
        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("member cannot found"));
        return chatRoom.getChatParticipants().stream()
                .anyMatch(el -> el.getMember().equals(member)) ? true : false;

    }

    @Transactional
    public void messageRead(Long roomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException("room cannot be found"));
        Member member = memberRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new EntityNotFoundException("member cannot found"));
        List<ReadStatus> readStatuses = readStatusRepository.findByChatRoomAndMember(chatRoom, member);
        readStatuses.stream().forEach(el -> el.updateIsRead(true));
    }

    public List<MyChatListResDto> getMyChatRooms() {
        Member member = memberRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new EntityNotFoundException("member cannot found"));
        List<ChatParticipant> chatParticipants = chatParticipantRepository.findAllByMember(member);
        return chatParticipants.stream().map(el -> MyChatListResDto.builder()
                .roomId(el.getChatRoom().getId())
                .roomName(el.getChatRoom().getName())
                .isGroupChat(el.getChatRoom().getIsGroupChat())
                .unReadCount(readStatusRepository.countByChatRoomAndMemberAndIsReadFalse(el.getChatRoom(), member))
                .build()).collect(Collectors.toList());
    }

    @Transactional
    public void leaveGroupChatRoom(Long roomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException("room cannot be found"));
        System.out.println("SecurityContextHolder.getContext().getAuthentication().getName() = " + SecurityContextHolder.getContext().getAuthentication().getName());
        Member member = memberRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new EntityNotFoundException("member cannot found"));

        if (chatRoom.getIsGroupChat().equals('N')) {
            throw new IllegalArgumentException("단체 채팅방이 아닙니다.");
        }

        ChatParticipant chatParticipant = chatParticipantRepository.findByChatRoomAndMember(chatRoom, member).orElseThrow(() -> new EntityNotFoundException("참여자를 찾을 수 없습니다"));
        chatParticipantRepository.delete(chatParticipant);

        if(chatParticipantRepository.findByChatRoom(chatRoom).isEmpty()){
            chatRoomRepository.delete(chatRoom);
        }
    }

    @Transactional
    public Long getOrCreatePrivateRoom(Long otherMemberId) {
        Member member = memberRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new EntityNotFoundException("member cannot found"));
        Member otherMember = memberRepository.findById(otherMemberId).orElseThrow(() -> new EntityNotFoundException("otherMember cannot found"));

        Optional<ChatRoom> chatRoom = chatParticipantRepository.findExistingPrivateRoom(member.getId(), otherMember.getId());
        if (chatRoom.isPresent()) {
            return chatRoom.get().getId();
        }

        ChatRoom newRoom = chatRoomRepository.save(ChatRoom.builder()
            .isGroupChat("N")
            .name(member.getName() + "-" + otherMember.getName())
            .build());

        addParticipantToRoom(newRoom, member);
        addParticipantToRoom(newRoom, otherMember);

        return newRoom.getId();
    }
}
