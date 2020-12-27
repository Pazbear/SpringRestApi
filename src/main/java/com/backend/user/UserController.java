package com.backend.user;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @RequestMapping("/")
    public Map<String, String> Hello(){
        Map<String, String> res = new HashMap<String, String>();
        res.put("msg", "hello");
        return res;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Map<String, String> getUser(@RequestBody UserDto user){
        Map<String, String> res = new HashMap<String, String>();
        if(user.getName().equals("min")) {
            res.put("user", "min");
        }else{
            res.put("user", "minx");
        }
        return res;
    }

}
