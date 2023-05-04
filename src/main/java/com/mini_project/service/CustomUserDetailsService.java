package com.mini_project.service;

import com.mini_project.dto.UserVO;
import com.mini_project.service.impl.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        UserVO user = userMapper.getUserById(userName);

        if(user == null) {
            throw new UsernameNotFoundException(userName);
        }

        return user;
    }


}