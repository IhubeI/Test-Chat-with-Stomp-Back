package com.test.springPlusChatting.handler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.springPlusChatting.dto.Message;
import com.test.springPlusChatting.service.ChattingService;

public class ChattingWebsocketHandler extends TextWebSocketHandler {

	// SLF4J를 이용하여 로거를 남기기 위한 과정
	// https://enai.tistory.com/36
	// 나중에 더 좋은 라이브러리가 생겨 교체하더라도, application의 코드를 변경할 필요가 없다는 장점이 있다.
	private Logger logger = LoggerFactory.getLogger(ChattingWebsocketHandler.class);

	@Autowired
	private ChattingService service;

	// WebSocketSession : 클라이언트 - 서버간 전이중통신을 담당하는 객체
	// 클라이언트의 최초 웹소켓 요청시 생성
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());
	// synchronizedSet : 동기화된 Set 반환(HashSet은 기본적으로 비동기)

	// afterConnectionEstablished - 클라이언트와 연결이 완료되고, 통신할 준비가 되면 실행
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 연결 요청이 접수되면 해당 클라이언트와 통신을 담당하는 WebSocketSession 객체가 전달되어 옴
		// 이를 필드에 선언해 준 sessions에 저장
		sessions.add(session);

		// 확인하고 주석 쳐야할 부분
		logger.info("{}연결됨", session.getId());
		System.out.println(session.getId() + "연결됨");
	}

	// handleTextMessage - 클라이언트로부터 텍스트 메시지를 받았을 때 실행
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		// 전달받은 내용은 JSON 형태의 String
		logger.info("전달받은 내용 : " + message.getPayload());

		// Jackson에서 제공하는 객체
		// JSON String -> VO Object
		ObjectMapper objectMapper = new ObjectMapper();

		Message msg = objectMapper.readValue(message.getPayload(), Message.class);

		// Message 객체 확인
		System.out.println(msg);

		// DB 삽입 서비스 호출
		int result = service.insertMessage(msg);
/////////////////////////////////////////////여기서부터 다시
		super.handleTextMessage(session, message);
	}

	// afterConnectionClosed - 클라이언트와 연결이 종료되면 실행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
		// 확인하고 주석 칠부분
		logger.info("{}연결끊김",session.getId());
	}

	// afterConnectionEstablished - 클라이언트와 연결이 완료되고, 통신할 준비가 되면 실행

}
