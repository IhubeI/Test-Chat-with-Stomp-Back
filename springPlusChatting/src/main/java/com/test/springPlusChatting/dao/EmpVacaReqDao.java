package com.test.springPlusChatting.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.springPlusChatting.dto.EmpVacaReqDto;
import com.test.springPlusChatting.mapper.EmpVacaReqMapper;

@Repository
public class EmpVacaReqDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EmpVacaReqMapper empVacaReqMapper;

	// seq
	public int sequence() {
		String sql = "select tb_VAcaReq_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	// C
	public void insert(EmpVacaReqDto empVacaReqDto) {
		String sql = "INSET INTO tb_VacaReq(vaca_No, applicantId, vaca_Tel, vaca_Sdate, vaca_Edate, vaca_Type, vaca_Reason, vaca_Reject) "
				+ "(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = { empVacaReqDto.getVacaNo(), empVacaReqDto.getApplicantId(), empVacaReqDto.getVacaSdate(),
				empVacaReqDto.getVacaEdate(), empVacaReqDto.getVacaType(), empVacaReqDto.getVacaReason(),
				empVacaReqDto.getVacaReject() };
		jdbcTemplate.update(sql, data);
	}

	// R
	public List<EmpVacaReqDto> selectList() {
		
		String sql = "select * from tb_VacaReq";
		Object[] data = {};
		return jdbcTemplate.query(sql, empVacaReqMapper, data);
	}

	// R
	public void selectOneByColumn() {

	}
//
//	// U
//	public void insert() {
//
//	}
//
//	// D
//	public void insert() {
//
//	}

}
