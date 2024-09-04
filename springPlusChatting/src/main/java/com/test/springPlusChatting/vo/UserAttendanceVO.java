package com.test.springPlusChatting.vo;

import java.time.LocalDateTime;

import lombok.Data;

//User-AAttendance를 전체적으로 조회하기위한 VO
@Data
public class UserAttendanceVO {
	private int taAttendanceNo; // 번호
	private String loginId; // 로그인 아이디 == UserDto의 loginId
	private LocalDateTime checkInTime; // 출근 시각
	private LocalDateTime checkOutTime; // 퇴근 시각
	private String userType; // user_type
	private String name; // name
	private String password; // password
	private String empGender; // emp_gender
	private String empHp; // emp_hp
	private String empEmail; // emp_email
	private String empBirth; // emp_birth
	private int empYrSal; // emp_yr_sal
	private String empSdate; // emp_sdate
	private String empWorkyn; // emp_work_yn default 'Y'
	private String empZip; // emp_zip
	private String empAddr; // emp_addr
	private String empDtAddr; // emp_dt_addr
	private int fileNo; // file_no
}
