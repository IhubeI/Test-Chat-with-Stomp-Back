package com.test.springPlusChatting.service;

import java.util.List;
import java.util.Map;

import com.test.springPlusChatting.dto.ChattingRoom;
import com.test.springPlusChatting.dto.MemberDto;
import com.test.springPlusChatting.dto.Message;

public class ChattingServiceImpl implements ChattingService{

	@Override
	public List<ChattingRoom> selectRoomList(String memberId) {
		return null;
	}

	@Override
	public int checkChattingNo(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createChattingNo(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMessage(Message msg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReadFlag(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Message> selectMessageList(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDto> selectTarget(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
