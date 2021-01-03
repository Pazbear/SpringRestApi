package com.backend.dto.chat;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ChatMessage {
    public enum MessageType {
        CONNECT, ENTER, TALK
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
    private LocalDateTime timeStamp;
}
