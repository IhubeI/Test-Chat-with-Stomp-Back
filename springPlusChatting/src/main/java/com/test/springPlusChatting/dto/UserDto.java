package com.test.springPlusChatting.dto;

import lombok.Data;

@Data
public class UserDto {
	private String loginId; // loginID
    private String userType; // user_type
    private String name;
    private String password;
    private String levelCd; // level_cd
    private String deptCd; // dept_cd
    private String empGender; // emp_gender
    private String empHp; // emp_hp
    private String empEmail; // emp_email
    private String empBirth; // emp_birth
    private String empEdu; // emp_edu
    private int empYrSal; // emp_yr_sal
    private String empSdate; // emp_sdate
    private String empEdate; // emp_edate
    private int empFinalMoney; // emp_final_money
    private String empReason; // retire_reason
    private String empMemo; // emp_memo
    private String empWorkyn; // emp_work_yn
    private String empAccount; // emp_account
    private String bkCd; // bk_cd
    private String empZip; // emp_zip
    private String empAddr; // emp_addr
    private String empDtAddr; // emp_dt_addr
    private int salSan; // sal_san
    private int salKo; // sal_ko
    private int salKun; // sal_kun
    private int salKuk; // sal_kuk
    private String salDate; // sal_date
    private int salPre; // sal_pre
    private int salAfter; // sal_after
    private int fileNo; // file_no
}
