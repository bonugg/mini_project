package com.example.mini_project.service;

import com.example.mini_project.mapper.UserMapper;
import com.example.mini_project.vo.UserVo;
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

    public List<UserVo> getUserList() {
        return userMapper.getUserList();
    }

    public UserVo getUserById(String id) {
        return userMapper.getUserById(id);
    }

    public UserVo getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    public void signup(UserVo userVo) { // 회원 가입
        if (!userVo.getUsername().equals("") && !userVo.getEmail().equals("")) {
            userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
            userMapper.insertUser(userVo);
        }
    }

    public void edit(UserVo userVo) { // 회원 정보 수정
        userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
        userMapper.updateUser(userVo);
    }

    public void withdraw(String id) { // 회원 탈퇴
        userMapper.deleteUser(id);
    }

    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }
}
