package com.backend.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private String id;
    private String phone;
    private String name;
    private String profile_image;
    private String background_image;
    private String status_msg;
    private String friends_list;

    @Builder
    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.phone = entity.getPhone();
        this.name = entity.getName();
        this.profile_image = entity.getProfile_image();
        this.background_image = entity.getBackground_image();
        this.status_msg = entity.getStatus_msg();
        this.friends_list = entity.getFriends_list();
    }
}
