package com.security.security.controller;

import com.security.security.dto.UserDto;
import com.security.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id){
        UserDto userDto = userService.getUserById(Long.valueOf(id));
        return userDto;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDto userDto){
        return String.valueOf(userService.addUser(userDto));
    }

}
