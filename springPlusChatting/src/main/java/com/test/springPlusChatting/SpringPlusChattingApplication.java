package com.test.springPlusChatting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// 일간/주간/월간 별로 근무시간 계산 할 예정
//@EnableScheduling//스케쥴링 서비스 활성화 설정 -- 할필요없어짐
@SpringBootApplication
public class SpringPlusChattingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPlusChattingApplication.class, args);
	}

}
