package com.chat.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.chat.dao.UserDao;
import com.chat.dto.UserDto;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserDao userDao;

	// 사용자 생성
	@PostMapping
	public ResponseEntity<Void> createUser(@RequestBody UserDto user) {
		userDao.createUser(user);
		return ResponseEntity.status(201).build(); // 201 Created
	}

	// 사용자 조회
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable String userId) {
		UserDto user = userDao.getUser(userId);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}

	// 모든 사용자 조회
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userDao.getAllUsers();
		return ResponseEntity.ok(users);
	}

	// 사용자 업데이트
	@PutMapping("/{userId}")
	public ResponseEntity<Void> updateUser(@PathVariable String userId, @RequestBody UserDto user) {
		user.setUserId(userId); // userId를 설정해야 하므로
		boolean updated = userDao.updateUser(user);
		return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}

	// 사용자 삭제
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		boolean deleted = userDao.deleteUser(userId);
		return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
}
