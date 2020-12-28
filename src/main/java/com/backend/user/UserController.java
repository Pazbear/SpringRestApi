package com.backend.user;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /*
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Map<String, Boolean> saveUser(@RequestBody UserDto userDto){
        Map<String, Boolean> res = new HashMap<>();
        userService.saveUser(userDto);
        res.put("success", true);
        return res;
    }*/
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public UserResponseDto findById (@RequestBody UserDto userDto) {
        return userService.findById(userDto.getId());
    }

}
