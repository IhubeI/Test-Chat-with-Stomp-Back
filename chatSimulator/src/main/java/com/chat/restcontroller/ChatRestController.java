package com.chat.restcontroller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompHeaders;
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
	
	//메세지 내용 수신
	@MessageMapping("/chat/{chatRoomId}")
    @SendTo("/sub/chat/{chatRoomId}")
	public MessageDto sendMessage(MessageDto message, @Header("simpSessionAttributes") Map<String, Object> sessionAttributes) {
		String userId = (String) sessionAttributes.get("userId");
		
		if(userId.equals(message.getSenderId())) {
			
			message.setTimestamp(LocalDateTime.now());
			
			// 메세지 내용 저장
			messageDao.saveMessage(message);
			
			
			return message; // 또는 필요한 로직을 추가
		}else {
			return null;
		}
		
	}
	

    // 특정 채팅방의 메시지를 조회하는 API
    @GetMapping("/messages")
    public List<MessageDto> getMessages(@RequestParam String chatRoomId) {
    	// 채팅방 ID로 메시지 조회
        return messageDao.getMessageByChatRoomId(chatRoomId);
    }

}