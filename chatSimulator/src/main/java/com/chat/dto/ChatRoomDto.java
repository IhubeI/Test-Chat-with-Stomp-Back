package com.chat.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ChatRoomDto {
    private String chatroomId;      // 채팅방 ID
    private String participant1Id;  // 참가자 1 ID
    private String participant2Id;  // 참가자 2 ID
    private Timestamp createdTime;   // 생성 시간
}
