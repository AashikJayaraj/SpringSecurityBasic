package com.example.JWTAuth.controller;


import com.example.JWTAuth.dto.UserDto;
import com.example.JWTAuth.service.AuthService;
import com.example.JWTAuth.service.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    JwtUserService userService;

    @Autowired
    AuthService authService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        System.out.println("NEW");
        Long id = userService.addUser(userDto);
        return new ResponseEntity<>(String.valueOf(id), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        String token = authService.login(userDto);

        return ResponseEntity.ok(token);
    }
    @GetMapping("/open")
    public String closed(){
        return "Hello(open-auth)";
    }
}
