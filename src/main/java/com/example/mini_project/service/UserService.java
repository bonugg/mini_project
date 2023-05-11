package com.example.mini_project.service;

import com.example.mini_project.mapper.UserMapper;
import com.example.mini_project.link_user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    public User getUserByEmailAndProvider(String email, String provider) {
        return userMapper.getUserByEmailAndProvider(email, provider);
    }

    public User getUserByNo(long no) {
        return userMapper.getUserByNo(no);
    }

    public void signup(User user) { // 회원 가입
        if (!user.getUsername().equals("") && !user.getEmail().equals("")) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userMapper.insertUser(user);
        }
    }

    public void edit(User user) { // 회원 정보 수정
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.updateUser(user);
    }

    public void withdraw(String email) { // 회원 탈퇴
        userMapper.deleteUser(email);
    } //회원 탈퇴

    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }
}
