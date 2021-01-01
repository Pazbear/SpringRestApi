package com.backend.model;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProfileModel {
    private int profileIdx;
    private String profileName;
    // 프로필 사진 URL
    private String profileURL;
}