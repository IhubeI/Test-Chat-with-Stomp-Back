package com.chat.dto;
import java.time.LocalDateTime;

import lombok.Data;

@Data // Getter, Setter, toString, equals, hashCode 메서드를 자동 생성
public class Message {
	private String chatId;
	private String chatroomId;
	private String senderId;
	private String receiverId;
    private String message; // 메시지 내용을 담는 필드
    private LocalDateTime timestamp; // 추가된 timestamp
}
