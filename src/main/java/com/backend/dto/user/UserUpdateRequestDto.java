package com.backend.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String id;
    private String phone;
    private String name;
    private String profile_image;
    private String background_image;
    private String status_msg;

    @Builder
    public UserUpdateRequestDto (String id, String phone, String name, String profile_image, String background_image,
                                 String status_msg) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.profile_image = profile_image;
        this.background_image = background_image;
        this.status_msg = status_msg;
    }
}
