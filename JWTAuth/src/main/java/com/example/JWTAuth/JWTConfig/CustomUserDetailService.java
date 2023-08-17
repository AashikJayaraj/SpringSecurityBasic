package com.example.JWTAuth.JWTConfig;

import com.example.JWTAuth.entity.JwtUser;
import com.example.JWTAuth.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JwtUser user = userRepository.findByUsername(username).orElseThrow(()->new RuntimeException("Not found"));
        return user;
    }
}
