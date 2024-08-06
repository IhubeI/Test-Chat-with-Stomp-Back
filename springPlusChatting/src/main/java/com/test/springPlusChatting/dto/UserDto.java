package com.test.springPlusChatting.dto;

import java.util.Date;
import lombok.Data;

@Data
public class UserDto {
        private String loginId; // loginId로 통일
        private String userType;
        private String name;
        private String password;
        private String levelCd;
        private String deptCd;
        private String empGender;
        private String empHp;
        private String empEmail;
        private Date empBirth;
        private String empEdu;
        private int empYrSal;
        private Date empSdate;
        private Date empEdate;
        private int empFinalMoney;
        private String empReason;
        private String empMemo;
        private String empWorkyn;
        private String empAccount;
        private String bkCd;
        private String empZip;
        private String empAddr;
        private String empDtAddr;
        private int salSan;
        private int salKo;
        private int salKun;
        private int salKuk;
        private Date salDate;
        private int salPre;
        private int salAfter;
        private int fileNo;
}
