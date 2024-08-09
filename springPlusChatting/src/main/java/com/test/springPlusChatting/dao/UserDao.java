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
		String sql = "INSERT INTO tb_userInfo("
				+ "loginID, name, "
				+ "password, emp_gender, emp_hp, "
				+ "emp_email, emp_birth, emp_yr_sal, "
				+ "emp_sdate, "
				+ "emp_zip, emp_addr, emp_dt_addr, "
				+ "file_no ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {userDto.getLoginId(), userDto.getName(),
				userDto.getPassword(), userDto.getEmpGender(), userDto.getEmpHp(),
				userDto.getEmpEmail(), userDto.getEmpBirth(), userDto.getEmpYrSal(),
				userDto.getEmpSdate(), 
				userDto.getEmpZip(), userDto.getEmpAddr(), userDto.getEmpDtAddr(),
				userDto.getFileNo()};
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
