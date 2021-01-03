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

    public Map<String ,String> createRoom(ChatRoomDto chatRoomCreateDto){
        Map<String, String> res = new HashMap<>();
        try {
            String randomId = UUID.randomUUID().toString();
            chatRoomCreateDto.setUrlId(randomId);
            String urlId = chatRoomRepository.save(chatRoomCreateDto.toEntity()).getUrlId();
            res.put("success", "true");
            res.put("urlId", urlId);
        }catch(Exception e){
            log.error(e.getMessage());
            res.put("success", "false");
        }
        return res;
    }

    public <T> void sendMessage(WebSocketSession session, T message){
        try{
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        }catch (IOException e){
            log.error(e.getMessage(), e);
        }
    }
}
