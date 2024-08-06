package com.test.springPlusChatting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.test.springPlusChatting.dto.UserDto;

public class UserMapper implements RowMapper<UserDto> {

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDto userDto = new UserDto();
		userDto.setLoginId(rs.getString("LOGINID"));
		
		
		return userDto;
	}

}
