package com.test.springPlusChatting.service;

import java.util.List;
import java.util.Map;

import com.test.springPlusChatting.dto.ChattingRoom;
import com.test.springPlusChatting.dto.MemberDto;
import com.test.springPlusChatting.dto.Message;

//협업
//교체 용이
//다중 상속
public interface ChattingService {
	
	List<ChattingRoom> selectRoomList(String memberId);
	
	int checkChattingNo(Map<String, Integer> map);
	
	int createChattingNo(Map<String, Integer> map);
	
	int insertMessage(Message msg);
	
	int updateReadFlag(Map<String, Object> paramMap);
	
	List<Message> selectMessageList(Map<String, Object> paramMap);
	
	// 채팅 상대 검색
	// @param map
	// @return memberList
	
	// Member-> 사원(EMP)로 대체 예정
	List<MemberDto> selectTarget(Map<String, Object> map);
}
