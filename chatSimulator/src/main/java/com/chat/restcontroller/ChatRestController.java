package com.chat.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dao.MessageDao;
import com.chat.dto.MessageDto;

@RestController
@RequestMapping("/chat")
public class ChatRestController {
	
	@Autowired
	private MessageDao messageDao;
	
	@MessageMapping("/chat/{chatRoomId}")
    @SendTo("/sub/chat/{chatRoomId}")
	public MessageDto sendMessage(MessageDto message) {
		// 메세지 내용 저장
		messageDao.saveMessage(message);
		return message; // 또는 필요한 로직을 추가
	}
	

    // 특정 채팅방의 메시지를 조회하는 API
    @GetMapping("/messages")
    public List<MessageDto> getMessages(@RequestParam String chatRoomId) {
    	// 채팅방 ID로 메시지 조회
        return messageDao.getMessageByChatRoomId(chatRoomId);
    }

}