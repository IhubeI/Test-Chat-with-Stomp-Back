package com.test.springPlusChatting.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.springPlusChatting.dto.UserDto;
import com.test.springPlusChatting.mapper.UserAttendanceMapper;
import com.test.springPlusChatting.mapper.UserMapper;
import com.test.springPlusChatting.vo.UserAttendanceVO;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserAttendanceMapper userAttendanceMapper;

	// 회원등록
	public void insert(UserDto userDto) {
		String sql = "INSERT INTO tb_userInfo(" + "loginID, name, " + "password, emp_gender, emp_hp, "
				+ "emp_email, emp_birth, emp_yr_sal, " + "emp_sdate, " + "emp_zip, emp_addr, emp_dt_addr, "
				+ "file_no ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = { userDto.getLoginId(), userDto.getName(), userDto.getPassword(), userDto.getEmpGender(),
				userDto.getEmpHp(), userDto.getEmpEmail(), userDto.getEmpBirth(), userDto.getEmpYrSal(),
				userDto.getEmpSdate(), userDto.getEmpZip(), userDto.getEmpAddr(), userDto.getEmpDtAddr(),
				userDto.getFileNo() };
		jdbcTemplate.update(sql, data);
	}

	// 회원목록
	public List<UserDto> selectList() {
		String sql = "SELECT * FROM tb_userInfo";
		return jdbcTemplate.query(sql, userMapper);
	}

	// 회원상세
	public UserDto selectOne(String loginId) {
		String sql = "SELECT * FROM tb_userInfo WHERE loginId = ?";
		Object[] data = { loginId };
		List<UserDto> list = jdbcTemplate.query(sql, userMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}

	// VO객체와 그에 해당 Mapper 만들어서 전체조회용으로 만드려고 만드는 메소드
	public List<UserAttendanceVO> selectListWithAttendance() {
		String sql = "select "
				+ "				a.ta_attendance_no, a.loginID, a.check_in_time, "
				+ "				a.check_out_time,"
				+ "				u.user_type,"
				+ "				u.name,"
				+ "				u.password,"
				+ "				u.emp_gender,"
				+ "				u.emp_hp,"
				+ "				u.emp_email,"
				+ "				u.emp_birth,"
				+ "				u.emp_yr_sal,"
				+ "				u.emp_sdate,"
				+ "				u.emp_work_yn,"
				+ "				u.emp_zip,"
				+ "				u.emp_addr,"
				+ "				u.emp_dt_addr,"
				+ "				u.file_no"
				+ "			from "
				+ "				tb_attendance a"
				+ "			join "
				+ "			    tb_userInfo u "
				+ "			on a.loginID = u.loginID";
		return jdbcTemplate.query(sql, userAttendanceMapper);
	}
}
