package com.test.springPlusChatting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.springPlusChatting.dao.ChatRoomRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
@Log4j2
public class RoomController {
    private final ChatRoomRepository repository;

    // 채팅방 목록 조회
    @GetMapping("/rooms")
    public String rooms(Model model) {
        log.info("# All Chat Rooms");
        model.addAttribute("list", repository.findAllRooms());
        return "/WEB-INF/views/rooms.jsp"; 
    }

    // 채팅방 개설
    @PostMapping("/room")
    public String create(@RequestParam String name, RedirectAttributes rttr) {
        log.info("# Create Chat Room, name: " + name);
        rttr.addFlashAttribute("roomName", repository.createChatRoomDTO(name));
        return "redirect:/chat/rooms";
    }

    // 채팅방 조회
    @GetMapping("/room")
    public String getRoom(@RequestParam String roomId, Model model) {
        log.info("# get Chat Room, roomID : " + roomId);
        model.addAttribute("room", repository.findRoomById(roomId));
        return "/WEB-INF/views/room.jsp";
    }
}