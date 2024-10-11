package com.chat.restcontroller;

import com.chat.dao.ChatRoomDao;
import com.chat.dto.ChatRoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomRestController {

    @Autowired
    private ChatRoomDao chatRoomDao;

    // 참가자 ID로 채팅방을 조회하는 엔드포인트
    @GetMapping("/chat/room")
    public ChatRoomDto getChatRoomByParticipants(@RequestParam String participant1Id,
                                                 @RequestParam String participant2Id) {
        // 두 참가자의 ID를 기준으로 채팅방 조회
        ChatRoomDto chatRoomDto = chatRoomDao.getChatRoomNoByParticipants(participant1Id, participant2Id);
        
        System.out.println(chatRoomDto);

        // 채팅방이 존재하지 않으면 null 반환 (프론트엔드에서 "무" 처리)
        return chatRoomDto; // 채팅방이 존재하면 반환
    }

    // 새로운 채팅방을 생성하는 엔드포인트
    @PostMapping("/chat/room")
    public void createChatRoom(@RequestBody ChatRoomDto chatRoomDto) {
        // DAO를 사용해 채팅방을 DB에 저장
        chatRoomDao.createChatRoom(chatRoomDto);
    }
}
