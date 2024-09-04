package com.test.springPlusChatting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.test.springPlusChatting.dto.EmpApprovalDto;

@Service
public class EmpApprovalMapper implements RowMapper<EmpApprovalDto>{

	@Override
	public EmpApprovalDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmpApprovalDto empApprovalDto = new EmpApprovalDto();
		empApprovalDto.setApproNo(rs.getInt("appro_No"));
		empApprovalDto.setApproType(rs.getString("appro_Type"));
		empApprovalDto.setApproDate(rs.getDate("appro_Date"));
		empApprovalDto.setApproYN(rs.getString("appro_YN"));// DB상에선 CHAR(1)
		empApprovalDto.setApproBos1(rs.getString("appro_Bos1"));
		empApprovalDto.setApproBos2(rs.getString("appro_Bos2"));
		empApprovalDto.setApproBos3(rs.getString("appro_Bos3"));
		empApprovalDto.setApproNo1(rs.getString("appro_No1"));
		empApprovalDto.setApproNo2(rs.getString("appro_No2"));
		empApprovalDto.setApproNo3(rs.getString("appro_No3"));
		return empApprovalDto;
	}

}
