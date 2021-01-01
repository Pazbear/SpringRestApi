package com.backend.dto;

import com.backend.dao.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String id;
    private String phone;
    private String name;
    private String profile_image;
    private String background_image;
    private String status_msg;
    private String friends_list;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.phone = entity.getPhone();
        this.name = entity.getName();
        this.profile_image = entity.getProfile_image();
        this.background_image = entity.getBackground_image();
        this.status_msg = entity.getStatus_msg();
        this.friends_list = entity.getFriends_list();
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + '\"' +
                ", \"phone\":\"" + phone + '\"' +
                ", \"name\":\"" + name + '\"' +
                ", \"profile_image\":\"" + profile_image + '\"' +
                ", \"background_image\":\"" + background_image + '\"' +
                ", \"status_msg\":\"" + status_msg + '\"' +
                ", \"friends_list\":\"" + friends_list + '\"' +
                '}';
    }
}
