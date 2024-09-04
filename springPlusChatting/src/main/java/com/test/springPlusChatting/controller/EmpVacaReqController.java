package com.test.springPlusChatting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.springPlusChatting.dao.EmpVacaReqDao;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/vacation")
public class EmpVacaReqController {
	
	@Autowired
	private EmpVacaReqDao empVacaReqDao;
	
	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/vacation/insert.jsp";
	}
	
	
}
