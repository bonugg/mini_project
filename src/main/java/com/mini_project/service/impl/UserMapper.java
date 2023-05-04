package com.mini_project.service.impl;

import com.mini_project.dto.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    public UserVO getUserById(String userName);

}