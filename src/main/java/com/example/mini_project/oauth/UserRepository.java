package com.example.mini_project.oauth;

import com.example.mini_project.link_user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndProvider(String email, String provider);
    Optional<User> findByIdAndProvider(String id, String provider);
    List<User> findByUsernameContaining(String username);
    @Query(value = "SELECT T.USERNAME FROM T_MEMBER_LINK T WHERE T.NO = :no", nativeQuery = true)
    String findUsername(long no);
    @Query(value = "SELECT COUNT(*) FROM T_MEMBER_LINK T WHERE T.ID = :id", nativeQuery = true)
    int idCheck(String id);
}
