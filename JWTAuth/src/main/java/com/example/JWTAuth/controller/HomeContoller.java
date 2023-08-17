package com.example.JWTAuth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeContoller {

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
}
