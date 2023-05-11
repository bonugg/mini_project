package com.example.mini_project.mapper;

import com.example.mini_project.link_user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getUserList(); // User 테이블 가져오기
    void insertUser(User user); // 회원 가입
    User getUserByEmail(String email); // 회원 정보 가져오기
    User getUserByEmailAndProvider(String email, String provider); // 회원 정보 가져오기
    User getUserByNo(long no); // 회원 정보 가져오기
    User getUserById(String id);
    void updateUser(User user); // 회원 정보 수정
    void deleteUser(String email); // 회원 탈퇴
}
