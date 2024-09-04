package com.test.springPlusChatting.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.springPlusChatting.mapper.EmpWorkTimeMapper;
//사원의 시간을 SELECT 구한 값을 UPDATE 시키기 위한 자바클래스
//굳이 필요하지 않음
@Repository
public class EmpWorkTimeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EmpWorkTimeMapper empWorkTimeMapper;

	public void insert(String Duration) {
		
	}

}
