package com.chat.dao;

import java.util.List;

import com.chat.dto.MessageDto;

public interface MessageDao {
	
	// 메시지 저장
    void saveMessage(MessageDto message);

    // 특정 채팅방의 메시지 목록 조회
    List<MessageDto> getMessageByChatRoomId(String chatRoomId, int beginRow, int endRow);

}
