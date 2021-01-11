package com.backend.service;


import com.backend.dao.ChatRoom;
import com.backend.dto.chat.ChatRoomDto;
import com.backend.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;


    public List<ChatRoomDto> findAllRoom(){
        List<ChatRoomDto> chatRoomDtos = new ArrayList<>();
        List<ChatRoom> chatRooms = chatRoomRepository.findAll();
        for (ChatRoom chatRoom : chatRooms) {
            chatRoomDtos.add(new ChatRoomDto(chatRoom));
        }
        return chatRoomDtos;
    }

    public ChatRoomDto findRoomById(String roomId){
        ChatRoom entity = chatRoomRepository.findById(roomId).orElseThrow(() ->
                new IllegalArgumentException(roomId + " Not Found"));
        return new ChatRoomDto(entity);
    }

    public Map<String ,String> createRoom(ChatRoomDto chatRoomDto){
        Map<String, String> res = new HashMap<>();
        try {
            String randomId = UUID.randomUUID().toString().substring(2, 12);
            chatRoomDto.setUrl_id(randomId);
            String urlId = chatRoomRepository.save(chatRoomDto.toEntity()).getUrl_id();
            res.put("success", "true");
            res.put("urlId", urlId);
        }catch(Exception e){
            log.error(e.getMessage());
            res.put("success", "false");
        }
        return res;
    }
}
