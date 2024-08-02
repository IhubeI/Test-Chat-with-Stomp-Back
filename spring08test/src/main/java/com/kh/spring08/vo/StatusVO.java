package com.kh.spring08.vo;

import lombok.Data;

//VO(Value Object)
//- DTO로 표현하기 힘든 변형된 데이털르 담기 위한 객체
@Data
public class StatusVO {
	private String title;
	private int cnt;
}
