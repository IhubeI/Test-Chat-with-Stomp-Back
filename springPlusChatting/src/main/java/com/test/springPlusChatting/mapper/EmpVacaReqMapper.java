package com.test.springPlusChatting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.test.springPlusChatting.dto.EmpVacaReqDto;

@Service
public class EmpVacaReqMapper implements RowMapper<EmpVacaReqDto> {

	@Override
	public EmpVacaReqDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EmpVacaReqDto empVacaReqDto = new EmpVacaReqDto();
		empVacaReqDto.setVacaNo(rs.getInt("vaca_No"));
		empVacaReqDto.setApplicantId(rs.getString("applicantId"));
		empVacaReqDto.setVacaTel(rs.getString("vaca_Tel"));
		empVacaReqDto.setVacaReqDate(rs.getDate("vaca_Sdate"));
		empVacaReqDto.setVacaEdate(rs.getDate("vaca_Edate"));
		empVacaReqDto.setVacaType(rs.getString("vaca_Type"));
		empVacaReqDto.setVacaReason(rs.getString("vaca_Reason"));
		empVacaReqDto.setVacaReject(rs.getString("vaca_Reject"));
		empVacaReqDto.setVacaReqDate(rs.getDate("vaca_ReqDate"));
		return empVacaReqDto;
	}

}
