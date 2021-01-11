package com.backend.controller;

import com.backend.model.SendSMSModel;
import com.backend.service.SendSMSService;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/SMS")
public class SendSMSController {

    private final SendSMSService sendSmsService;

    public SendSMSController(SendSMSService sendSmsService) {
        this.sendSmsService = sendSmsService;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public JSONObject sendSMS(@RequestBody SendSMSModel sendSMSModel) {

        JSONObject res = new JSONObject();

        try {
            JSONObject obj = sendSmsService.cerNumSend(sendSMSModel.getPhoneNumber());
            log.info(obj.toString());
            res.put("Success", "True");
            res.put("CertificationNumber", obj.get("cerNum"));

            return res;
        } catch (CoolsmsException e) {
            log.error(e.getMessage());
            log.error("CoolSMS ErrorCode : " + Integer.toString(e.getCode()));
            res.put("Success", "False");

            return res;
        }

    }

}
