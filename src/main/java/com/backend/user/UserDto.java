package com.backend.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class UserDto {
    @Id//primaryKey
    @GeneratedValue//autoIncreament
    private int id;

    private String phone;
    private String name;
    private String profileImage;
    private String backgroundImage;
    private String status;

}
