//package com.test.springPlusChatting.service;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import com.test.springPlusChatting.dao.EmpAttendanceDao;
//import com.test.springPlusChatting.dao.EmpWorkTimeDao;
//import com.test.springPlusChatting.dto.EmpAttendanceDto;
//
//import jakarta.transaction.Transactional;
//
//@Service
//public class ProcessAttendanceService {
//
//	
//	@Autowired
//	private EmpWorkTimeDao empWorkTimeDao;
//
//	@Autowired
//	private EmpAttendanceDao empAttendanceDao;
//
//	// 밀리초를 시:분:초로 변환 하는 메소드
//	private String millisToTime(long millis) {
//		long hours = TimeUnit.MILLISECONDS.toHours(millis);
//		long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) % 60;
//		long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
//
//		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
//	}
//
//	// 일간 근무 시간 처리(매일 자정(00:00))
//	@Transactional
////	@Scheduled(cron = "0 0 0 * * ?")
//	@Scheduled(cron = "0 * * * * ?")
//	public void today() {
//		System.out.println("일간 근무 시간 처리 중...");
//		List<EmpAttendanceDto> list = empAttendanceDao.selectList();
//
//		// 날짜와 시간을 포함한 형식을 위한 SimpleDateFormat 생성
//		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//		for (EmpAttendanceDto dto : list) {
//			System.out.println("Login ID: " + dto.getLoginId());
//
//			// 체크인 시간과 체크아웃 시간을 밀리초로 변환
//			long checkInMillis = dto.getCheckInTime().getTime();
//			long checkOutMillis = dto.getCheckOutTime().getTime();
//
//			// 체크인 및 체크아웃 시간 출력
//			System.out.println("Check-In Time: " + dateTimeFormat.format(dto.getCheckInTime()));
//			System.out.println("Check-Out Time: " + dateTimeFormat.format(dto.getCheckOutTime()));
//
//			// 체크인과 체크아웃 시간 차이 계산
//			long durationMillis = checkOutMillis - checkInMillis;
//
//			// 밀리초 차이를 시:분:초로 변환
//			System.out.println("Duration: " + millisToTime(durationMillis));
//
//			// [1] 잘찍히면 두시간값의 차를 구해서 WorkTimeDao에 저장 하기전에 또검사
////			empWorkTimeDao.insert(millisToTime(durationMillis));
//		}
//
//	}
//
//	// 주간 근무 시간 처리(매주 월요일 오전 1시)
//	@Transactional
//	@Scheduled(cron = "0 0 1 ? * MON")
//	public void week() {
//		System.out.println("주간 근무 시간 처리 중");
//
//	}
//
//	// 월간 근무 시간 처리(매월 1일 자정(00:00))
//	@Transactional
//	@Scheduled(cron = "0 0 0 1 * ?")
//	public void month() {
//		System.out.println("월간 근무 시간 처리 중");
//
//	}
//
//}
