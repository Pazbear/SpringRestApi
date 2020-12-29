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

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String saveUser (@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String findById (@RequestBody UserDto userDto) {
        return userService.findById(userDto.getId()).toString();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update (@RequestBody UserUpdateRequestDto requestDto) {
        return userService.update(requestDto.getId(), requestDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete (@RequestBody UserDto userDto) {
        return userService.delete(userDto.getId());
    }
}
