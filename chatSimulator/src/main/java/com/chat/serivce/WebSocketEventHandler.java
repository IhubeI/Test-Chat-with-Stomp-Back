package com.chat.serivce;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Service
public class WebSocketEventHandler {
	
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	// 사용자 세션 정보 저장소
	private Map<String, String> userList = Collections.synchronizedMap(new HashMap<>());
	
	
	@EventListener
	public void whenUserSubscribe(SessionSubscribeEvent event){
		
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		String sessionId = accessor.getSessionId();
		// WebSocket 세션에서 userId 가져오기
        String userId = (String) accessor.getSessionAttributes().get("userId");
		
        
        //저장소에 사용자 등록
      	userList.put(sessionId, userId);
      	
      //채널 /users에 전파
      Set<String> values = new TreeSet<>(userList.values());
      messagingTemplate.convertAndSend("/sub/users", values);
	}
	
	
	
	@EventListener
	public void whenUserLeave(SessionDisconnectEvent event) {
		//헤더 정보를 추출
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		String sessionId = accessor.getSessionId();
		
		//저장소에서 사용자 제거
		userList.remove(sessionId);
		
		//채널 /users에 전파
		Set<String> values = new TreeSet<>(userList.values());
		messagingTemplate.convertAndSend("/sub/users", values);
		
	}
}
