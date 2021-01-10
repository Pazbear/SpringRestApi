package com.backend.service;

import com.amazonaws.AmazonClientException;
import com.backend.model.S3FileManageModel;
import com.backend.api.S3FileManageApi;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
public class S3FileManageService {

    private final S3FileManageApi s3FileUploadService;

    public S3FileManageService(S3FileManageApi s3FileUploadService) {
        this.s3FileUploadService = s3FileUploadService;
    }

    public Map<String, String> profileSave(S3FileManageModel s3FileManageModel, MultipartFile multipartFile) {
        Map<String, String> res = new HashMap<>();
        try {
            if (multipartFile != null) {
                String url = s3FileUploadService.upload(multipartFile);
                if (url != null) {
                    s3FileManageModel.setProfileURL(url);
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


    public Map<String, String> profileDelete(S3FileManageModel s3FileManageModel) {
        Map<String, String> res = new HashMap<>();
        try {
            s3FileUploadService.deleteObject(s3FileManageModel.getProfileURL());
            res.put("Success1", "true");
        } catch (AmazonClientException amazonClientException) {
            res.put("success2", "false");
        } catch (Exception e) {
            res.put("Success3", "false");
        }
        return res;
    }
}
