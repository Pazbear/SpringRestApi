package com.backend.user;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/user")
public class UserController {
    private UserService userService;
    @RequestMapping("/")
    public Map<String, String> Hello(){
        Map<String, String> res = new HashMap<String, String>();
        res.put("msg", "hello");
        return res;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Map<String, Boolean> saveUser(@RequestBody UserDto userDto){
        Map<String, Boolean> res = new HashMap<>();
        userService.saveUser(userDto);
        res.put("success", true);
        return res;
    }

}
