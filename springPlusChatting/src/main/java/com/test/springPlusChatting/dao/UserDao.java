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

	
	//회원등록
	public void insert(UserDto userDto) {
		String sql = "INSERT INTO tb_userInfo() values()";
		Object[] data = {};
		jdbcTemplate.update(sql, data);
	}
	
	//회원목록
	public List<UserDto> selectList() {
		String sql = "SELECT * FROM tb_userInfo";
		return jdbcTemplate.query(sql, userMapper);
	}
	
	
	//회원상세
	public UserDto selectOne(String loginId) {
		String sql = "SELECT * FROM tb_userInfo WHERE loginId = ?";
		Object[] data = { loginId };
		List<UserDto> list = jdbcTemplate.query(sql, userMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
}
