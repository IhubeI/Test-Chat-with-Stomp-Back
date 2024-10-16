package com.chat.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chat.dao.MessageDao;
import com.chat.dto.MessageDto;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	@Autowired
	private SqlSession session;

	@Override
    public void saveMessage(MessageDto message) {
		session.insert("Message.saveMessage", message);
    }

    @Override
    public List<MessageDto> getMessageByChatRoomId(String chatRoomId, int beginRow, int endRow) {
    	Map<String, Object> params = new HashMap<>();
		params.put("chatRoomId", chatRoomId);
		params.put("beginRow", beginRow);
		params.put("endRow",  endRow);
        return session.selectList("Message.getMessageByChatRoomId", params);
    }

}
