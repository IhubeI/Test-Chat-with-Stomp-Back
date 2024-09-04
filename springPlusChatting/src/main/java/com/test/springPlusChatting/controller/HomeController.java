package com.test.springPlusChatting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.springPlusChatting.dao.UserDao;
import com.test.springPlusChatting.dto.UserDto;

@Controller
//유일하게 공용주소가 안붙는 컨트롤러 -> 공용주소 없음
public class HomeController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/") // 가장 짧은 주소
	public String home(Model model) {
		List<UserDto> list = userDao.selectList();
//		List<UserAttendanceVO> listPlus = userDao.selectListWithAttendance();
//		if(!listPlus.isEmpty()) {
//			model.addAttribute("listPlus", listPlus);// 조회결과 -> Attendance 추가
//		}
		model.addAttribute("list", list);// 조회결과
		return "/WEB-INF/views/home.jsp";
	}

}
