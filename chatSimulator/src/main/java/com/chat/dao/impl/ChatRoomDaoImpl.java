package com.chat.dao.impl;

import com.chat.dao.ChatRoomDao;
import com.chat.dto.ChatRoomDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChatRoomDaoImpl implements ChatRoomDao {

    @Autowired
    private SqlSession sqlSession;

    // 채팅방 생성
    @Override
    public void createChatRoom(ChatRoomDto chatRoom) {
        String first = chatRoom.getParticipant1Id();
        String second = chatRoom.getParticipant2Id();
        
        // 참가자 ID가 동일한 경우 예외 발생
        if (first.equals(second)) {
            throw new IllegalArgumentException("참가자는 서로 달라야 합니다.");
        }
        
        // 사전 순으로 정렬
        if (first.compareTo(second) < 0) {
            chatRoom.setParticipant1Id(first);
            chatRoom.setParticipant2Id(second);           
        } else {
            chatRoom.setParticipant1Id(second);
            chatRoom.setParticipant2Id(first);  
        }

        // 중복 채팅방 존재 여부 확인
        ChatRoomDto existingRoom = getChatRoomNoByParticipants(chatRoom.getParticipant1Id(), chatRoom.getParticipant2Id());
        if (existingRoom != null) {
            throw new IllegalArgumentException("이 참가자 간의 채팅방이 이미 존재합니다.");
        }

        // 채팅방 생성
        sqlSession.insert("ChatRoomMapper.createChatRoom", chatRoom);
    }

    // 참여자 ID로 채팅방 조회
    @Override
    public ChatRoomDto getChatRoomNoByParticipants(String participant1Id, String participant2Id) {
        Map<String, String> params = new HashMap<>();
        params.put("participant1Id", participant1Id);
        params.put("participant2Id", participant2Id);
        return sqlSession.selectOne("ChatRoomMapper.getChatRoomByParticipants", params);
    }

    // 모든 채팅방 조회
    @Override
    public List<ChatRoomDto> getAllChatRooms() {
        return sqlSession.selectList("ChatRoomMapper.getAllChatRooms");
    }

    // 채팅방 삭제
    @Override
    public void deleteChatRoom(String chatroomId) {
        sqlSession.delete("ChatRoomMapper.deleteChatRoom", chatroomId);
    }

}
