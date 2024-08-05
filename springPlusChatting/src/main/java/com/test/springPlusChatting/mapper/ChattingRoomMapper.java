package com.test.springPlusChatting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.test.springPlusChatting.dto.ChattingRoom;

public class ChattingRoomMapper implements RowMapper<ChattingRoom> {

	@Override
	public ChattingRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		 ChattingRoom chattingRoom = new ChattingRoom();
	        chattingRoom.setChattingNo(rs.getInt("CHATTING_NO"));
	        chattingRoom.setLastMessage(rs.getString("LAST_MESSAGE"));
	        chattingRoom.setSendTime(rs.getDate("SEND_TIME"));
	        chattingRoom.setTarget(rs.getString("TARGET"));
	        chattingRoom.setTargetNickName(rs.getString("TARGET_NICKNAME"));
	        chattingRoom.setTargetProfile(rs.getString("TARGET_PROFILE"));
	        chattingRoom.setNotReadCount(rs.getInt("NOT_READ_COUNT"));
	        return chattingRoom;
	}
	
}
