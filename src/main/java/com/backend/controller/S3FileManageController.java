package com.backend.controller;

import com.backend.model.S3FileManageModel;
import com.backend.service.S3FileManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/profile")
public class S3FileManageController {

    private final S3FileManageService s3FileManageService;

    public S3FileManageController(S3FileManageService s3FileManageService) {
        this.s3FileManageService = s3FileManageService;
    }

    @RequestMapping("/save")
    public ResponseEntity saveProfile(S3FileManageModel s3FileManageModel, @RequestPart(value="profile",
            required = false) final MultipartFile multipartFile) {
        try {
            return new ResponseEntity(s3FileManageService.profileSave(s3FileManageModel, multipartFile), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping("/delete")
    public ResponseEntity deleteProfile(S3FileManageModel s3FileManageModel) {
        try {
            return new ResponseEntity(s3FileManageService.profileDelete(s3FileManageModel), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
