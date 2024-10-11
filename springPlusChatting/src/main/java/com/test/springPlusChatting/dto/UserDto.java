package com.test.springPlusChatting.dto;

import lombok.Data;

//프로토타입으로 컴팩트 하게 만들예정
@Data
public class UserDto {
	private String loginId; // login_id
	private String password; //password
    private String name; // name
    
}