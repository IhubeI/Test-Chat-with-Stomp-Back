package com.chat.dao;

public interface RefreshTokenDao {
	// 리프레시 토큰 저장
	void save(String userId, String token);

	// 사용자 ID로 리프레시 토큰 조회
	String findByUserId(String userId);

	// 사용자 ID로 리프레시 토큰 삭제
	void deleteByUserId(String userId);
}
