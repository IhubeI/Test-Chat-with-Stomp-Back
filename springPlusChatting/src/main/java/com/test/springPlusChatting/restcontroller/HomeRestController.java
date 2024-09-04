package com.test.springPlusChatting.restcontroller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.springPlusChatting.dao.EmpAttendanceDao;
import com.test.springPlusChatting.dto.EmpAttendanceDto;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/rest/home")
public class HomeRestController {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

	@Autowired
	private EmpAttendanceDao empAttendanceDao;

	@PostMapping("/start")
	public String startCommuting(HttpSession session) {
		// 출근 시간 처리 로직
		String loginId = (String) session.getAttribute("loginId");
		int seq = empAttendanceDao.sequence();

		empAttendanceDao.insert(loginId, seq);
		// 시간 받기
		LocalDateTime checkOutTime = empAttendanceDao.selectOneById(loginId).getCheckInTime();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("a h:mm:ss", Locale.KOREAN);
		// 포맷된 문자열로 변환
		String formattedCheckOutTime = checkOutTime.format(formatter);
		return formattedCheckOutTime;

	}

	@PostMapping("/end")
	public String endCommuting(HttpSession session) {
		// 퇴근 시간 처리 로직
		String loginId = (String) session.getAttribute("loginId");

		EmpAttendanceDto empAttendanceDto = empAttendanceDao.selectOneById(loginId);
		empAttendanceDao.updateCheckOutTime(empAttendanceDto.getTaAttendanceNo());

		// 시간 받기
		LocalDateTime checkOutTime = empAttendanceDao.selectOneById(loginId).getCheckOutTime();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("a h:mm:ss", Locale.KOREAN);
		// 포맷된 문자열로 변환
		String formattedCheckOutTime = checkOutTime.format(formatter);

		return formattedCheckOutTime;
	}

}
