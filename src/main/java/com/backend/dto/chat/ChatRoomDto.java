package com.backend.dto.chat;

import com.backend.dao.ChatRoom;
import com.backend.service.ChatService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoomDto {
    private String id;
    private String url_id;

    public ChatRoomDto(ChatRoom entity){
        this.id = entity.getId();
        this.url_id = entity.getUrl_id();
    }

    public ChatRoom toEntity(){
        return ChatRoom.builder()
                .id(id)
                .url_id(url_id)
                .build();
    }
}
