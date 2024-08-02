package com.test.springPlusChatting.dto;

import java.sql.Date;

import lombok.Data;
// Message.java -> ChattingDto.
@Data
public class Message {
	private int messageNo; // 메시지 번호
    private String messageContent; // 메시지 내용
    private String readFlag; // 읽음 여부 -->
    private String sender; // 보낸 회원 번호 --> loginID로 연동 할거니까 String 변환
    private String target; // 받는 회원 번호 --> loginID로 연동 할거니까 String 변환
    private int chattingNo; // 채팅방 번호
    private Date sendTime; // 메시지 보낸 시간
    // 추가할거면 파일을 넣어볼까요?
}
