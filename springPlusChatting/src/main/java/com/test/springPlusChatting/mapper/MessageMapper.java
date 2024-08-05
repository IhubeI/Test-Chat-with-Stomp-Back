package com.test.springPlusChatting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.test.springPlusChatting.dto.Message;

public class MessageMapper implements RowMapper<Message> {

	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();
        message.setMessageNo(rs.getInt("MESSAGE_NO"));
        message.setMessageContent(rs.getString("MESSAGE_CONTENT"));
        message.setReadFlag(rs.getString("READ_FL"));
        message.setSender(rs.getString("SENDER"));
        message.setChattingNo(rs.getInt("CHATTING_NO"));
        message.setSendTime(rs.getDate("SEND_TIME"));
        return message;
	}
	
}
