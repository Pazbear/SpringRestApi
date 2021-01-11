package com.backend.service;

import com.backend.api.SendSMSApi;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class SendSMSService {

    private final SendSMSApi sendSmsApi;

    public SendSMSService(SendSMSApi sendSmsApi) {
        this.sendSmsApi = sendSmsApi;
    }

    public JSONObject cerNumSend (String phoneNumber) throws CoolsmsException {

        Random random = new Random();
        String cerNum = "";
        for (int i = 0; i < 4; i++) {
            cerNum += Integer.toString(random.nextInt(10));
        }

        log.info("수신자 번호 : " + phoneNumber);
        log.info("인증번호 : cerNum");

        JSONObject obj = sendSmsApi.certifyPhoneNumber(phoneNumber, cerNum);
        obj.put("cerNum", cerNum);

        return obj;

    }


}
