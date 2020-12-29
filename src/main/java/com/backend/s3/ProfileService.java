package com.backend.s3;

import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileService {

    private final S3FileUploadService s3FileUploadService;

    public ProfileService(S3FileUploadService s3FileUploadService) {
        this.s3FileUploadService = s3FileUploadService;
    }

    public Map<String, Boolean> profileSave(ProfileModel profileModel, MultipartFile multipartFile) {
        Map<String, Boolean> res = new HashMap<>();
        try {
            if (multipartFile != null) {
                profileModel.setProfileURL(s3FileUploadService.upload(multipartFile));
            }
            res.put("Success", true);

            return res;
        } catch (Exception e) {
            res.put("Success", false);

            return res;
        }
    }
}
