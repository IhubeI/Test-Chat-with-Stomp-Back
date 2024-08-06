package com.test.springPlusChatting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
//유일하게 공용주소가 안붙는 컨트롤러 -> 공용주소 없음
public class HomeController {
	
	
	@RequestMapping("/")//가장 짧은 주소
	public String home(){
		return "/WEB-INF/views/home.jsp";
	}
	
}
