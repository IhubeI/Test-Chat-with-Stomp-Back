package com.test.springPlusChatting.dto;

import lombok.Data;

//프로토타입으로 컴팩트 하게 만들예정
@Data
public class UserDto {
	private String loginId; // loginID
    private String userType; // user_type
    private String name; // name
    private String password; //password
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
