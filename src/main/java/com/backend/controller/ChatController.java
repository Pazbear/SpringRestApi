package com.backend.controller;

import com.backend.dto.chat.ChatRoomDto;
import com.backend.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public Map<String, String> createRoom(@RequestBody ChatRoomDto chatRoomCreateDto){
        return chatService.createRoom(chatRoomCreateDto);
    }

    @RequestMapping(value="/getAllRooms")
    public List<ChatRoomDto> findAllRoom(){
        return chatService.findAllRoom();
    }
}
