package com.chat.advice;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice(대상 지정과 관련된 옵션)
//@ControllerAdvice(basePackages = {"com.kh.spring06.controller"})
@RestControllerAdvice(annotations = {RestController.class})
public class EmptyStringAdvice {
	@InitBinder//컨트롤러가 처리하기 전(전처리) 작업을 지정
	public void initBinder(WebDataBinder binder) {
		//binder에 어떤 도구를 설정하느냐에 따라 처리 규칙이 바뀜
		//binder.registerCustomEditor(자료형, 도구);
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}