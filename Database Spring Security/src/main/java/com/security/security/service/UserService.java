package com.security.security.service;

import com.security.security.dto.UserDto;
import com.security.security.entity.User;
import com.security.security.enums.Roles;
import com.security.security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Long addUser(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRoles());
        return userRepo.save(user).getId();
    }

    public UserDto getUserById(Long userId){
        User user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("NOT FOUND"));
        UserDto userDto = new UserDto(user.username, user.password, user.getRole());

        return userDto;
    }
}
