package com.backend.user;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User{

    @Id
    private String id; //PK
    @NotNull
    private String phone;
    @NotNull
    private String name;
    private String profile_image;
    private String background_image;
    private String status_msg;
    private String friends_list;

    @Builder
    public User(String id, String phone, String name, String profile_image, String background_image,
                String status_msg, String friends_list){
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.profile_image = profile_image;
        this.background_image = background_image;
        this.status_msg = status_msg;
        this.friends_list = friends_list;
    }
}
