package com.chat.configuration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.chat.serivce.TokenService;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {

	@Autowired
	private TokenService tokenService;

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {

		// to subscriber
		config.enableSimpleBroker("/sub");

		// 클라이언트로부터 메시지를 받을 api의 prefix 설정
		// publish
		config.setApplicationDestinationPrefixes("/pub");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/stomp/chat").setAllowedOrigins("http://localhost:3000") // CORS설정
				.withSockJS() // SockJS 활성화: WebSocket 미지원 시 폴백 옵션 사용
				.setInterceptors(new HttpSessionHandshakeInterceptor() {

					@Override
					public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
							WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
						List<String> cookiesHeader = request.getHeaders().get(HttpHeaders.COOKIE);

						if (cookiesHeader != null && !cookiesHeader.isEmpty()) {
							for (String cookie : cookiesHeader) {
								// 정규 표현식을 사용하여 accessToken 값 추출
								String[] cookies = cookie.split(";");
								for (String c : cookies) {
									if (c.trim().startsWith("accessToken=")) {
										String token = c.split("=")[1]; // accessToken 값 추출
										// 토큰 검증
										if (tokenService.check(token) != null) {
											attributes.put("userId", tokenService.check(token).getUserId());  // WebSocket 세션에 저장
											return true;
										}
									}
								}
							}
						}

						// 인증 실패 시 WebSocket 연결 거부
						response.setStatusCode(HttpStatus.UNAUTHORIZED);
						return false; // 핸드쉐이크 거부
					}
				});
	}
}
