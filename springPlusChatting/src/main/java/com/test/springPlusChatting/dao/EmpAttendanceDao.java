package com.test.springPlusChatting.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.springPlusChatting.dto.EmpAttendanceDto;
import com.test.springPlusChatting.mapper.EmpAttendanceMapper;

@Repository
public class EmpAttendanceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EmpAttendanceMapper empAttendanceMapper;

	public int sequence() {
		String sql = "select tb_attendance_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	// C
	public void insert(String loginId, int seq) {
		String sql = "INSERT INTO tb_attendance (ta_attendance_no, loginID) VALUES (?, ?)";
		Object[] data = { seq, loginId };
		jdbcTemplate.update(sql, data);
	}

	// R
	public List<EmpAttendanceDto> selectList() {
		String sql = "SELECT * FROM tb_attendance";
		return jdbcTemplate.query(sql, empAttendanceMapper);
	}

	// D
	public void delete() {

	}

	// R - key = loginId
	public EmpAttendanceDto selectOneById(String loginId) {
		String sql = "SELECT * FROM tb_attendance WHERE loginId = ? order by ta_attendance_no desc";
		Object[] data = { loginId };
		List<EmpAttendanceDto> list = jdbcTemplate.query(sql, empAttendanceMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}

	// U
	public void updateCheckOutTime(int taAttendanceNo) {
		String sql = "UPDATE tb_attendance SET check_out_time = systimestamp WHERE ta_attendance_no = ?";
		Object[] data = { taAttendanceNo };
		jdbcTemplate.update(sql, data);
	}

	public List<EmpAttendanceDto> selectListById(String loginId) {

		String sql = "SELECT * FROM tb_attendance WHERE loginId = ? order by ta_attendance_no";
		Object[] data = { loginId };
		return jdbcTemplate.query(sql, empAttendanceMapper, data);
	}

}
