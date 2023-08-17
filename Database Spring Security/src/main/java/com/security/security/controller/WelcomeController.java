package com.security.security.controller;

import com.security.security.dto.UserDto;
import com.security.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class WelcomeController {
    @GetMapping("/open")
    public String open(){
        return "Hello(Open)";
    }
    @GetMapping("/closed")
    public String closed(){
        return "Hello(Closed)";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Hello(ADMIN)";
    }
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDto userDto){
        return String.valueOf(userService.addUser(userDto));
    }
}
