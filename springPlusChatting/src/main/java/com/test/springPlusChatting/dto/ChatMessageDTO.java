package com.test.springPlusChatting.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDTO {
	private String roomId; // 채팅방 번호
    private String writer; // 채팅 작성자
    private String message; // 보내려는 메시지
}
