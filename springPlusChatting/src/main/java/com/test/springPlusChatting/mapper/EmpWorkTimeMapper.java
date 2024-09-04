package com.test.springPlusChatting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.test.springPlusChatting.dto.EmpWorkTimeDto;
//사원의 시간을 SELECT 구한 값을 UPDATE 시키기 위한 자바클래스
//굳이 필요하지 않음
@Service
public class EmpWorkTimeMapper implements RowMapper<EmpWorkTimeDto> {

	@Override
	public EmpWorkTimeDto mapRow(ResultSet rs, int rowNum) throws SQLException {

		EmpWorkTimeDto empWorkTimeDto = new EmpWorkTimeDto();
		empWorkTimeDto.setWorkNo(rs.getInt("work_no"));
		empWorkTimeDto.setLoginId(rs.getString("loginID"));
		empWorkTimeDto.setWorkTimeDay(rs.getInt("work_time_day"));
		empWorkTimeDto.setWorkTimeWeek(rs.getInt("work_time_week"));
		empWorkTimeDto.setWorkTimeMonth(rs.getInt("work_time_month"));
		empWorkTimeDto.setWorkTimeTotal(rs.getInt("work_time_total"));
		empWorkTimeDto.setRecordDate(rs.getDate("record_date"));
		
		return empWorkTimeDto;
	}

}
