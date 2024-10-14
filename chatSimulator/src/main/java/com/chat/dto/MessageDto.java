package com.chat.dto;
import java.time.LocalDateTime;

import lombok.Data;

@Data // Getter, Setter, toString, equals, hashCode 메서드를 자동 생성
public class MessageDto {
	private String chatId;
	private String chatRoomId;
	private String senderId;
	private String receiverId;
    private String message; // 메시지 내용을 담는 필드
    private LocalDateTime timestamp; // 추가된 timestamp
}
