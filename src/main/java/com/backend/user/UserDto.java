package com.backend.user;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private String id;
    private String phone;
    private String name;
    private String profile_image;
    private String background_image;
    private String status_msg;
    private String friends_list;

    public User toEntity(){
        return User.builder()
                .id(id)
                .phone(phone)
                .name(name)
                .profile_image(profile_image)
                .background_image(background_image)
                .status_msg(status_msg)
                .friends_list(friends_list)
                .build();
    }

    @Builder
    public UserDto(String id, String phone, String name, String profile_image, String background_image,
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
