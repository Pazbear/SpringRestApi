package com.backend.s3;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProfileModel {
    private int profileIdx;
    private String profileName;
    // 프로필 사진 URL
    private String profileURL;
}