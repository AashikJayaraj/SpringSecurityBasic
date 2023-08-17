package com.example.JWTAuth.service;

import com.example.JWTAuth.dto.UserDto;
import com.example.JWTAuth.entity.JwtUser;
import com.example.JWTAuth.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Long addUser(UserDto userDto){
        JwtUser user = new JwtUser();
        user.setUsername(userDto.getUsername());
        user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());
        System.out.println("DTO==>username "+userDto.getUsername()+" pwd "+ userDto.getPassword()+" role "+ userDto.getRole());
        System.out.println("USER==>username "+user.getUsername()+" pwd "+ user.getPassword()+" role "+ user.getRole());
        return userRepository.save(user).getId();
    }

    public UserDto getUserById(Long userId){
        JwtUser user = this.userRepository.findById(userId).orElseThrow(()-> new RuntimeException("NOT FOUND"));
        UserDto userDto = new UserDto(user.getUsername(), user.getPassword(), user.getRole());
        return userDto;
    }

}
