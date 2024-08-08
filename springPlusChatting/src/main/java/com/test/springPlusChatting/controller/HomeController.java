package com.test.springPlusChatting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
//유일하게 공용주소가 안붙는 컨트롤러 -> 공용주소 없음
public class HomeController {
	
	
	@RequestMapping("/")//가장 짧은 주소
	public String home(Model model, @RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword){
		return "/WEB-INF/views/home.jsp";
	}
	
}
