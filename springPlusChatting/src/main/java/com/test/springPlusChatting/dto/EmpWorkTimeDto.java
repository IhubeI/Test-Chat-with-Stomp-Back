package com.test.springPlusChatting.dto;

import java.sql.Date;

import lombok.Data;
//사원의 시간을 SELECT 구한 값을 UPDATE 시키기 위한 자바클래스
//굳이 필요하지 않음
//tb_attendance의 값을 참조하여 생성/갱신/삭제/조회 수행 위한 Dto
@Data
public class EmpWorkTimeDto {
	private int workNo; // 테이블 기본키 넘버
	private String loginId; // Session에 로그인되어있는 Id === userId
	private int workTimeDay; // 일간
	private int workTimeWeek; // 주간
	private int workTimeMonth; // 월간
	private int workTimeTotal; // 총계
	private Date recordDate; // 집계 날짜
}
