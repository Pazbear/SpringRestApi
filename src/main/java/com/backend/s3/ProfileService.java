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
                String url = s3FileUploadService.upload(multipartFile);
                if (url != null) {
                    profileModel.setProfileURL(url);
                    res.put("Success1", true);
                } else {
                    res.put("Success2", false);
                }
            }else{
                res.put("Success3", false);
            }
            return res;
        } catch (Exception e) {
            res.put("Success4", false);

            return res;
        }
    }
}
