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
		userDto.setLoginId(rs.getString("loginID"));
		userDto.setUserType(rs.getString("user_type"));
		userDto.setName(rs.getString("name"));
		userDto.setPassword(rs.getString("password"));
		userDto.setLevelCd(rs.getString("level_cd"));
		userDto.setDeptCd(rs.getString("dept_cd"));
		userDto.setEmpGender(rs.getString("emp_gender"));
		userDto.setEmpHp(rs.getString("emp_hp"));
		userDto.setEmpEmail(rs.getString("emp_email"));
		userDto.setEmpBirth(rs.getString("emp_birth"));
		userDto.setEmpEdu(rs.getString("emp_edu"));
		userDto.setEmpYrSal(rs.getInt("emp_yr_sal"));
		userDto.setEmpSdate(rs.getString("emp_sdate"));
		userDto.setEmpEdate(rs.getString("emp_edate"));
		userDto.setEmpFinalMoney(rs.getInt("emp_final_money"));
		userDto.setEmpMemo(rs.getString("emp_memo"));
		userDto.setEmpWorkyn(rs.getString("emp_work_yn"));
		userDto.setEmpReason(rs.getString("retire_reason"));
		userDto.setEmpAccount(rs.getString("emp_account"));
		userDto.setBkCd(rs.getString("bk_cd"));
		userDto.setEmpZip(rs.getString("emp_zip"));
		userDto.setEmpAddr(rs.getString("emp_addr"));
		userDto.setEmpDtAddr(rs.getString("emp_dt_addr"));
		userDto.setSalSan(rs.getInt("sal_san"));
		userDto.setSalKo(rs.getInt("sal_ko"));
		userDto.setSalKun(rs.getInt("sal_kun"));
		userDto.setSalKuk(rs.getInt("sal_kuk"));
		userDto.setSalDate(rs.getString("sal_date"));
		userDto.setSalPre(rs.getInt("sal_pre"));
		userDto.setSalAfter(rs.getInt("sal_after"));
		userDto.setFileNo(rs.getInt("file_no"));

		return userDto;
	}

}
