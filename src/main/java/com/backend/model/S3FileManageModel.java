package com.backend.model;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class S3FileManageModel {
    private String profileName;
    private String profileURL;
}