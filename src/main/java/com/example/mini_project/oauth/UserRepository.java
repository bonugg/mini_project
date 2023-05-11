package com.example.mini_project.oauth;

import com.example.mini_project.link_user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndProvider(String email, String provider);
}
