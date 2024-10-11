package com.chat.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chat.dao.UserDao;
import com.chat.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public void createUser(UserDto user) {
		session.insert("UserMapper.insertUser", user);
	}

	@Override
	public UserDto getUser(String userId) {
		return session.selectOne("UserMapper.selectUser", userId);
	}

	@Override
	public List<UserDto> getAllUsers() {
		return session.selectList("UserMapper.selectAllUsers");
	}

	@Override
	public boolean updateUser(UserDto user) {
		return session.update("UserMapper.updateUser", user) > 0;
	}

	@Override
	public boolean deleteUser(String userId) {
		return session.delete("UserMapper.deleteUser", userId) > 0;
	}

}
