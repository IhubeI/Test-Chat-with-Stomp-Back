package com.test.springPlusChatting.handler;

import java.time.ZoneId;
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
import com.google.gson.Gson;
import com.test.springPlusChatting.dto.Message;
import com.test.springPlusChatting.service.ChattingService;

public class ChattingWebsocketHandler extends TextWebSocketHandler {

	private Logger logger = LoggerFactory.getLogger(ChattingWebsocketHandler.class);

	@Autowired
	private ChattingService service;

	// WebSocketSession : 클라이언트 - 서버간 전이중통신을 담당하는 객체 (JDBC Connection과 유사)
	// 클라이언트의 최초 웹소켓 요청 시 생성
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());
	// synchronizedSet : 동기화된 Set 반환(HashSet은 기본적으로 비동기)
	// -> 멀티스레드 환경에서 하나의 컬렉션에 여러 스레드가 접근하여 의도치 않은 문제가 발생되지 않게 하기 위해
	// 동기화를 진행하여 스레드가 여러 순서대로 한 컬렉션에 순서대로 접근할 수 있게 변경

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 연결 요청이 접수되면 해당 클라이언트와 통신을 담당하는 WebSocketSession 객체가 전달되어 옴
		// 이를 필드에 선언해 준 sessions에 저장
		sessions.add(session);

		logger.info("{} 연결됨", session.getId());
		System.out.println(session.getId() + " 연결됨");
	}

	// handlerTextMessage - 클라이언트로부터 텍스트 메시지를 받았을 때 실행
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

		if (result > 0) {

			java.util.Date utilDate = new java.util.Date();

			long milliSeconds = utilDate.getTime();
			java.sql.Date sqlDate = new java.sql.Date(milliSeconds);
			// 변환된 java.sql.Date를 Message 객체에 설정
			msg.setSendTime(sqlDate);

			for (WebSocketSession s : sessions) {
				String loginMemberId = ((Member) s.getAttributes().get("loginMember")).getMemberNo();
				logger.debug("loginMemberId : " + loginMemberId);

				// 메시지의 targetNo 또는 sender가 현재 로그인된 회원의 ID와 일치하는지 확인
				if (loginMemberId.equals(msg.getTarget()) || loginMemberId.equals(msg.getSender())) {
					s.sendMessage(new TextMessage(new Gson().toJson(msg)));
				}
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
		logger.info("{} 연결끊김", session.getId());
	}
}
