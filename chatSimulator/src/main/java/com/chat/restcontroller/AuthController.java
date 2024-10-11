package com.chat.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dao.RefreshTokenDao;
import com.chat.dao.UserDao;
import com.chat.dto.UserDto;
import com.chat.serivce.TokenService;
import com.chat.vo.LoginRequestVO;
import com.chat.vo.UserClaimVO;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private RefreshTokenDao refreshTokenDao; // RefreshTokenDao 추가

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequestVO loginRequestVO, HttpServletResponse response) {
		UserDto user = userDao.getUser(loginRequestVO.getUserId());

		if (user != null && user.getUserPassword().equals(loginRequestVO.getPassword())) {
			// 클레임 생성
			UserClaimVO claim = new UserClaimVO();
			claim.setUserId(user.getUserId());
			claim.setEmail(user.getEmail());

			// 토큰 생성
			String accessToken = tokenService.createAccessToken(claim);
			String refreshToken = tokenService.createRefreshToken(claim); // Redis에 저장됨

			// 쿠키에 리프레시 토큰 설정
			ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", refreshToken).httpOnly(true)
					.secure(false) // 로컬에서는 false
					.path("/").maxAge(365 * 24 * 60 * 60).build();

			// 쿠키에 액세스 토큰 설정 (HTTP-Only 쿠키)
			ResponseCookie accessCookie = ResponseCookie.from("accessToken", accessToken).httpOnly(true).secure(false) // 로컬에서는
																														// false
					.path("/").maxAge(5 * 60) // 15분으로 설정 (예시)
					.build();

			// 응답에 쿠키 추가
			response.addHeader("Set-Cookie", refreshCookie.toString());
			response.addHeader("Set-Cookie", accessCookie.toString());

			return ResponseEntity.ok("로그인 성공"); // 성공 메시지 반환
		}

		return ResponseEntity.status(401).body("로그인 실패"); // 401 Unauthorized
	}

	// 리프레시 토큰 재발급
	@PostMapping("/refresh")
	public ResponseEntity<String> refreshToken(
	        @CookieValue(value = "refreshToken") String refreshToken,
	        HttpServletResponse response) {
	    // 리프레시 토큰 검증
	    UserClaimVO claim = tokenService.check(refreshToken);
	    if (claim == null) {
	        return ResponseEntity.status(401).body("Invalid refresh token"); // 401 Unauthorized
	    }

	    // 새로운 액세스 및 리프레시 토큰 생성
	    String newAccessToken = tokenService.createAccessToken(claim);
	    String newRefreshToken = tokenService.createRefreshToken(claim); // Redis에 새로운 리프레시 토큰 저장

	    // 새로운 리프레시 토큰 저장
	    refreshTokenDao.save(claim.getUserId(), newRefreshToken); // Redis에 새로운 리프레시 토큰 저장

	    // 새로운 액세스 토큰을 HTTP-Only 쿠키로 설정
	    ResponseCookie accessTokenCookie = ResponseCookie.from("accessToken", newAccessToken).httpOnly(true)
	            .secure(false) // 로컬에서는 false
	            .path("/").maxAge(5 * 60) // 5분 유효
	            .build();

	    // 새로운 리프레시 토큰을 HTTP-Only 쿠키로 설정
	    ResponseCookie refreshTokenCookie = ResponseCookie.from("refreshToken", newRefreshToken).httpOnly(true)
	            .secure(false) // 로컬에서는 false
	            .path("/").maxAge(365 * 24 * 60 * 60) // 1년 유효
	            .build();

	    // 응답에 쿠키 추가
	    response.addHeader("Set-Cookie", accessTokenCookie.toString());
	    response.addHeader("Set-Cookie", refreshTokenCookie.toString());

	    return ResponseEntity.ok("Token refreshed successfully");
	}
	
	// 액세스 토큰 유효성 검증
	@GetMapping("/validate")
	public UserClaimVO validateAccessToken(@CookieValue(value = "accessToken", required = false) String accessToken) {
	    if (accessToken == null) return null; // 액세스 토큰이 없으면 null 반환
	    
	    UserClaimVO claim = tokenService.check(accessToken); // 액세스 토큰 검증
	    
	    if (claim != null) {
	        return claim; // 유효한 경우 클레임 반환
	    }
	    
	    return null; // 유효하지 않은 경우 null 반환
	}
}
