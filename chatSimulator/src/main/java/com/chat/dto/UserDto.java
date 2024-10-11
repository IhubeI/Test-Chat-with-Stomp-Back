package com.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
// UserDTO user = new UserDTO(1L, "John", "john@example.com"); 이딴식으로 초기화 가능
@AllArgsConstructor
public class UserDto {
	private String userId; // 사용자 ID -> user_id
	private String userPassword; // 사용자 비밀번호 -> user_password
    private String userName; // 사용자 이름 -> user_name
    private String email; // 사용자 이메일 -> email
}
