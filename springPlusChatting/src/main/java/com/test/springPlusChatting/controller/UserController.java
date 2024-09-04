package com.test.springPlusChatting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.springPlusChatting.dao.EmpAttendanceDao;
import com.test.springPlusChatting.dao.UserDao;
import com.test.springPlusChatting.dto.EmpAttendanceDto;
import com.test.springPlusChatting.dto.UserDto;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private EmpAttendanceDao empAttendanceDao;

	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/user/join.jsp";
	}

	@PostMapping("/join")
	public String join(@ModelAttribute UserDto userDto) {

		userDao.insert(userDto);

		return "redirect:/";
	}

	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/user/login.jsp";
	}

	@PostMapping("/login")
	public String login(@RequestParam String loginId, @RequestParam String password, HttpSession session) {

		UserDto userDto = userDao.selectOne(loginId);
		if (userDto == null)
			return "redirect:login?error";

		boolean isValid = password.equals(userDto.getPassword());
		if (isValid == false)
			return "redirect:login?error";

		session.setAttribute("loginId", loginId);
		session.setAttribute("userType", userDto.getUserType());

		return "redirect:/";// 홈으로 이동
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		// 세션에서 loginId 지우기전에 ta_end_time 업데이트 하고 로그아웃
		String loginId = (String) session.getAttribute("loginId");
		


		session.removeAttribute("loginId");
		session.removeAttribute("userType");
		// session.invalidate();//세션 만료(소멸) 명령 - 권장하지 않음

		return "redirect:/";

	}

	@RequestMapping("/time")
	public String time(HttpSession session, Model model) {
		String loginId = (String) session.getAttribute("loginId");
		
		List<EmpAttendanceDto> list = empAttendanceDao.selectListById(loginId);
		model.addAttribute("list", list);

		return "/WEB-INF/views/user/time.jsp";
	}

}
