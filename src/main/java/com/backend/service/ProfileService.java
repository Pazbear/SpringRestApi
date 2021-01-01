package com.backend.service;

import com.amazonaws.AmazonClientException;
import com.backend.model.ProfileModel;
import com.backend.api.S3FileManageApi;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileService {

    private final S3FileManageApi s3FileUploadService;

    public ProfileService(S3FileManageApi s3FileUploadService) {
        this.s3FileUploadService = s3FileUploadService;
    }

    public Map<String, String> profileSave(ProfileModel profileModel, MultipartFile multipartFile) {
        Map<String, String> res = new HashMap<>();
        try {
            if (multipartFile != null) {
                String url = s3FileUploadService.upload(multipartFile);
                if (url != null) {
                    profileModel.setProfileURL(url);
                    res.put("Success", "true");
                    res.put("url", url);
                } else {
                    res.put("Success1", "false");
                }
            } else{
                res.put("Success2", "false");
            }
            return res;
        } catch (Exception e) {
            res.put("Success3", "false");

            return res;
        }
    }


    public Map<String, String> profileDelete(ProfileModel profileModel) {
        Map<String, String> res = new HashMap<>();
        try {
            s3FileUploadService.deleteObject(profileModel.getProfileURL());
            res.put("Success1", "true");
        } catch (AmazonClientException amazonClientException) {
            res.put("success2", "false");
        } catch (Exception e) {
            res.put("Success3", "false");
        }
        return res;
    }
}
