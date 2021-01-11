package com.backend.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name ="chatroom")
public class ChatRoom {
    @Id
    private String id;

    @Column
    private String url_id;

    @Builder
    public ChatRoom(String id, String url_id){
        this.id = id;
        this.url_id = url_id;
    }

}