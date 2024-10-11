package com.chat.restcontroller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.chat.dto.Message;

@Controller
public class ChatRestController {

	@MessageMapping("/chat/{chatRoomId}")
    @SendTo("/sub/chat/{chatRoomId}")
	public Message sendMessage(Message message) {
		System.out.println("message : " + message);
		return message; // 또는 필요한 로직을 추가
	}

}