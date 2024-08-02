package com.test.springPlusChatting.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.test.springPlusChatting.service.ChattingService;

public class ChattingWebsocketHandler extends TextWebSocketHandler {
	
	// SLF4J를 이용하여 로거를 남기기 위한 과정
	// https://enai.tistory.com/36
	// 나중에 더 좋은 라이브러리가 생겨 교체하더라도, application의 코드를 변경할 필요가 없다는 장점이 있다.
	private Logger logger = LoggerFactory.getLogger(ChattingWebsocketHandler.class);

	@Autowired
	private ChattingService service;
	
}
