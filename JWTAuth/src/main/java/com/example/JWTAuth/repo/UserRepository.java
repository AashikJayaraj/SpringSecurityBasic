package com.example.JWTAuth.repo;

import com.example.JWTAuth.entity.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<JwtUser, Long> {
    Optional<JwtUser> findByUsername(String username);
}
