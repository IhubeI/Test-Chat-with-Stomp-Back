package com.chat.serivce;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.configuration.TokenProperties;
import com.chat.dao.RefreshTokenDao; // RefreshTokenDao 주입
import com.chat.vo.UserClaimVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {

	@Autowired
	private TokenProperties tokenProperties;

	// Redis에 리프레시 토큰을 저장하는 DAO
	@Autowired
	private RefreshTokenDao refreshTokenDao;

	// 토큰 생성 메소드
	public String createAccessToken(UserClaimVO vo) {
		// 키 생성
		SecretKey key = Keys.hmacShaKeyFor(tokenProperties.getSecret().getBytes(StandardCharsets.UTF_8));
		// 만료시간 계산
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();
		c.add(Calendar.MINUTE, tokenProperties.getExpire());
		Date limit = c.getTime();
		// 토큰
		return Jwts.builder().signWith(key).expiration(limit).issuer(tokenProperties.getIssuer()).issuedAt(now)
				.claim("userId", vo.getUserId()).claim("email", vo.getEmail()).compact();
	}

	// 리프레시 토큰 생성
	public String createRefreshToken(UserClaimVO vo) {
		// 키 생성
		SecretKey key = Keys.hmacShaKeyFor(tokenProperties.getSecret().getBytes(StandardCharsets.UTF_8));
		// 만료시간 계산
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();
		c.add(Calendar.YEAR, 1); // 1년 추가
		Date limit = c.getTime();
		// 토큰
		String token = Jwts.builder().signWith(key).expiration(limit).issuer(tokenProperties.getIssuer()).issuedAt(now)
				.claim("userId", vo.getUserId()).claim("email", vo.getEmail()).compact();

		// Redis에 리프레시 토큰 저장
		refreshTokenDao.save(vo.getUserId(), token);

		return token;
	}

	// 토큰 검증 메소드
	public UserClaimVO check(String token) {
		// 키 생성
		SecretKey key = Keys.hmacShaKeyFor(tokenProperties.getSecret().getBytes(StandardCharsets.UTF_8));
		// 토큰 해석
		Claims claims = (Claims) Jwts.parser().verifyWith(key).requireIssuer(tokenProperties.getIssuer()).build()
				.parse(token).getPayload();
		// 결과 생성 및 반환
		UserClaimVO vo = new UserClaimVO();
		vo.setUserId(claims.get("userId", String.class)); // 클레임에서 userId 가져오기
		vo.setEmail(claims.get("email", String.class)); // 클레임에서 email 가져오기
		return vo;
	}

	// 리프레시 토큰 검증 메서드
	public boolean isRefreshTokenValid(String token) {
		// 사용자 ID 추출 (토큰에서 사용자 ID를 가져오는 로직 필요)
		UserClaimVO claim = check(token);
		if (claim == null) {
			return false; // 유효하지 않은 토큰
		}

		// Redis에서 해당 사용자 ID와 일치하는 리프레시 토큰 가져오기
		String storedToken = refreshTokenDao.findByUserId(claim.getUserId());

		// 리프레시 토큰이 Redis에 존재하는지 확인
		return token.equals(storedToken);
	}

}
