package com.backend.controller;

import com.backend.model.ProfileModel;
import com.backend.service.ProfileService;
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
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping("/save")
    public ResponseEntity saveProfile(ProfileModel profileModel, @RequestPart(value="profile",
            required = false) final MultipartFile multipartFile) {
        try {
            return new ResponseEntity(profileService.profileSave(profileModel, multipartFile), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping("/delete")
    public ResponseEntity deleteProfile(ProfileModel profileModel) {
        try {
            return new ResponseEntity(profileService.profileDelete(profileModel), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
