package com.backend.api;

import com.backend.PrivateInfo;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
public class SendSMSApi {

    private Message coolsms = new Message(PrivateInfo.coolSMS_api_key, PrivateInfo.coolSMS_api_secret);

    public SendSMSApi() {

    }
    public JSONObject certifyPhoneNumber(String phoneNumber, String cerNum)
            throws CoolsmsException{

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phoneNumber);
        params.put("from", PrivateInfo.sendingPhoneNumber);
        params.put("type", "sms");
        params.put("text", "toy_project / 인증번호는[" + cerNum + "]입니다.");
//      params.put("app_version", "toy_project 1.0");


        return (JSONObject) coolsms.send(params);

    }
}
