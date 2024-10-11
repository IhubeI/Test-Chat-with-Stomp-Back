package com.chat.dao;

import com.chat.dto.ChatRoomDto;

import java.util.List;

public interface ChatRoomDao {

    // 채팅방 생성
    void createChatRoom(ChatRoomDto chatRoom);

    // 참여자 ID로 채팅방 조회
    ChatRoomDto getChatRoomNoByParticipants(String participant1Id, String participant2Id);

    // 모든 채팅방 조회
    List<ChatRoomDto> getAllChatRooms();

    // 채팅방 삭제 (chatroomId로 삭제)
    void deleteChatRoom(String chatroomId);
}
