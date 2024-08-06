package com.test.springPlusChatting.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.springPlusChatting.dto.UserDto;
import com.test.springPlusChatting.mapper.UserMapper;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserMapper userMapper;

	
	//예시
	public List<UserDto> selectList() {
		String sql = "SELECT * FROM tb_userInfo";
		return jdbcTemplate.query(sql, userMapper);
	}
	
	
	//예시
	public List<UserDto> selectOne(Long id) {
		String sql = "SELECT * FROM tb_userInfo WHERE loginID = ?";
		Object[] data = { id };
		return jdbcTemplate.query(sql, userMapper, data);
	}
}
