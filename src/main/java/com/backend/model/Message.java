package com.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Message {
    private String userFrom;
    private String message;
    private LocalDateTime timeStamp;

    public Message(){

    }
    public Message(String userFrom, String message, LocalDateTime timeStamp){
        this.userFrom = userFrom;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "userFrom='" + userFrom + '\'' +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
