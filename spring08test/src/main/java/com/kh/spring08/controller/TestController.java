//package com.kh.spring08.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
// 
//import com.spring.demo.console.vo.User;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//
//@Tag(name = "swagger 테스트 API", description = "swagger 테스트를 진행하는 API")
//@RestController
//@RequestMapping("/test/")
//public class TestController {
//	
//	@Operation(summary = "User 정보 Get", description = "User 정보를 조회합니다.")
//	@GetMapping("/get-userinfo")
//	public ResponseEntity<User> getTest() {
//		
//		User user = new User();
//		
//		user.setUserName("아무개");
//		user.setUserAge(20);
//		
//		return ResponseEntity.ok(user);
//	}
//}