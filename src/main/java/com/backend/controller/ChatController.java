package com.backend.controller;

import com.backend.dto.chat.ChatRoom;
import com.backend.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ChatRoom createRoom(@RequestParam String name){
        return chatService.createRoom(name);
    }

    @RequestMapping(value="/getAllRooms")
    public List<ChatRoom> findAllRoom(){
        return chatService.findAllRoom();
    }
}
