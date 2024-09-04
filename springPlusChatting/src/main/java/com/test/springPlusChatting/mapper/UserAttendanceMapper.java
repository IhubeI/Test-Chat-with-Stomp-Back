package com.test.springPlusChatting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.test.springPlusChatting.vo.UserAttendanceVO;

//User-AAttendance를 전체적으로 조회하기위한 Mapper
@Service
public class UserAttendanceMapper implements RowMapper<UserAttendanceVO> {

	@Override
	public UserAttendanceVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserAttendanceVO userAttendanceVO = new UserAttendanceVO();

		userAttendanceVO.setTaAttendanceNo(rs.getInt("ta_attendance_no"));
		userAttendanceVO.setLoginId(rs.getString("loginID"));
		Timestamp checkInTimestamp = rs.getTimestamp("check_in_time");
		if (checkInTimestamp != null) {
			userAttendanceVO.setCheckInTime(checkInTimestamp.toLocalDateTime());
		} else {
			userAttendanceVO.setCheckInTime(null);
		}

		Timestamp checkOutTimestamp = rs.getTimestamp("check_out_time");
		if (checkOutTimestamp != null) {
			userAttendanceVO.setCheckOutTime(checkOutTimestamp.toLocalDateTime());
		} else {
			userAttendanceVO.setCheckOutTime(null);
		}

		userAttendanceVO.setUserType(rs.getString("user_type"));
		userAttendanceVO.setName(rs.getString("name"));
		userAttendanceVO.setPassword(rs.getString("password"));
		userAttendanceVO.setEmpGender(rs.getString("emp_gender"));
		userAttendanceVO.setEmpEmail(rs.getString("emp_email"));
		userAttendanceVO.setEmpBirth(rs.getString("emp_birth"));
		userAttendanceVO.setEmpYrSal(rs.getInt("emp_yr_sal"));
		userAttendanceVO.setEmpSdate(rs.getString("emp_sdate"));
		userAttendanceVO.setEmpWorkyn(rs.getString("emp_work_yn"));
		userAttendanceVO.setEmpZip(rs.getString("emp_zip"));
		userAttendanceVO.setEmpAddr(rs.getString("emp_addr"));
		userAttendanceVO.setEmpDtAddr(rs.getString("emp_dt_addr"));
		userAttendanceVO.setFileNo(rs.getInt("file_no"));

		return userAttendanceVO;
	}

}
