package com.test.springPlusChatting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.springPlusChatting.dao.UserDao;
import com.test.springPlusChatting.dto.UserDto;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/user/join.jsp";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute UserDto userDto) {
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/user/login.jsp";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String loginId, @RequestParam String password, HttpSession session) {
		
		UserDto userDto = userDao.selectOne(loginId);
		if(userDto == null)
			return "redirect:login?error";
		
		boolean isValid = password.equals(userDto.getPassword());
		if(isValid == false)
			return "redirect:login?error";
		
		session.setAttribute("loginId", loginId);
//		session.setAttribute("createdLevel", memberDto.getMemberLevel());
		return "redirect:/";// 홈으로 이동
	}
	
	
}
