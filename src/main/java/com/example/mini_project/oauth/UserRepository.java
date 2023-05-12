package com.example.mini_project.oauth;

import com.example.mini_project.link_user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndProvider(String email, String provider);
    Optional<User> findByIdAndProvider(String id, String provider);
    Optional<User> findById(long id);
    @Query(value = "SELECT COUNT(*) FROM T_MEMBER_LINK T WHERE T.EMAIL = :email", nativeQuery = true)
    int idCheck(String email);
}
