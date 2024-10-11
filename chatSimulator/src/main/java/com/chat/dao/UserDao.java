package com.chat.dao;

import java.util.List;

import com.chat.dto.UserDto;

public interface UserDao {
	// 유저 생성
	void createUser(UserDto user);

	// 유저 아이디로 정보 가져오기
	UserDto getUser(String userId);

	// 모든 유저 리스트
	List<UserDto> getAllUsers();

	// 유저 정보 갱신
	boolean updateUser(UserDto user);

	// 유저 삭제
	boolean deleteUser(String userId);
}
