package com.backend.controller;

import com.backend.api.FCMService;
import com.backend.dto.chat.ChatRoomDto;
import com.backend.service.ChatService;
import com.backend.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final UserService userService;
    private final ChatService chatService;
    ObjectMapper objectMapper = new ObjectMapper();
    private FCMService fcmService = new FCMService(objectMapper);

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public Map<String, String> sendMessage(@RequestBody Map<String, Object> param){
        Map<String, String> res = new HashMap<>();
        try {
            String receiverToken = userService.findById((String) param.get("receiver")).getToken();
            String senderName = userService.findById((String) param.get("sender")).getName();
            fcmService.sendMessageTo(receiverToken, senderName, (String) param.get("message"));
        }catch (IOException e){
            e.printStackTrace();
            res.put("success", "false");
            return res;
        }
        res.put("success", "true");
        return res;
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public Map<String, String> createRoom(@RequestBody ChatRoomDto chatRoomDto){
        log.debug("/api/chat/create");

        return chatService.createRoom(chatRoomDto);
    }

    @RequestMapping(value="/getAllRooms")
    public List<ChatRoomDto> findAllRoom(){
        return chatService.findAllRoom();
    }
}
