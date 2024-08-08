package com.test.springPlusChatting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.test.springPlusChatting.dto.UserDto;

@Service
public class UserMapper implements RowMapper<UserDto> {

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDto userDto = new UserDto();
        userDto.setLoginId(rs.getString("loginID")); // ID is a String
        userDto.setUserType(rs.getString("user_type"));
        userDto.setName(rs.getString("name"));
        userDto.setPassword(rs.getString("password"));
        userDto.setEmpGender(rs.getString("emp_gender"));
        userDto.setEmpHp(rs.getString("emp_hp"));
        userDto.setEmpEmail(rs.getString("emp_email"));
        userDto.setEmpBirth(rs.getString("emp_birth"));
        userDto.setEmpYrSal(rs.getInt("emp_yr_sal"));
        userDto.setEmpSdate(rs.getString("emp_sdate"));
        userDto.setEmpWorkyn(rs.getString("emp_work_yn"));
        userDto.setEmpZip(rs.getString("emp_zip"));
        userDto.setEmpAddr(rs.getString("emp_addr"));
        userDto.setEmpDtAddr(rs.getString("emp_dt_addr"));
        userDto.setFileNo(rs.getInt("file_no"));

		return userDto;
	}

}
