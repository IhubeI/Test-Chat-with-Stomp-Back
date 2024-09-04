package com.test.springPlusChatting.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.springPlusChatting.dto.EmpApprovalDto;
import com.test.springPlusChatting.mapper.EmpApprovalMapper;

@Repository
public class EmpApprovalDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EmpApprovalMapper empApprovalMapper;

	// C --> 행동(보고서 / 휴가신청서 작성)에 따른 기본 결재 데이터 생성 결재자에 대한 정보 NULL
	public void insert(EmpApprovalDto empApprovalDto) {
		String sql = "INSERT INTO tb_Approval(appro_No, appro_Type, appro_YN) values(tb_Approval_seq.nextval, ?, 'N')";
		Object[] data = { empApprovalDto.getApproType() };
		jdbcTemplate.update(sql, data);
	}

	// R
	public List<EmpApprovalDto> selectList() {
		String sql = "SELECT * FROM tb_Approval";
		return jdbcTemplate.query(sql, empApprovalMapper);
	}

//	// U --> sql 쿼리를 세개 작성
//	public boolean update(EmpApprovalDto empApprovalDto) {
//		String sql;
//		//
//		if(empApprovalDto.getApproBos1().isEmpty() && empApprovalDto.getApproNo2().isEmpty() && empApprovalDto.getApproNo3().isEmpty()) {
//			sql = "UPDATE SET FROM";
//			Object[] data = {};
//			return jdbcTemplate.update(sql, data) > 0;
//		}else if()
//		
//		
//	}
//
//	// D
//	public void insert() {
//
//	}

}
