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
public class ChatRoomDto {
    private String id;
    private String urlId;

    public ChatRoomDto(ChatRoom entity){
        this.id = entity.getId();
        this.urlId = entity.getUrlId();
    }

    public ChatRoom toEntity(){
        return ChatRoom.builder()
                .id(id)
                .urlId(urlId)
                .build();
    }

    public void handleActions(WebSocketSession session, ChatMessage chatMessage,
                              ChatService chatService){
        if(chatMessage.getType().equals(ChatMessage.MessageType.ENTER)){
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
        }
        sendMessage(chatMessage, chatService);
    }

    public <T> void sendMessage(T message, ChatService chatService){
        sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
    }
}
