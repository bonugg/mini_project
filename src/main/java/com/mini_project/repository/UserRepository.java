package com.mini_project.repository;

import com.mini_project.dto.LinkTable;
import com.mini_project.dto.UserDTO;
import com.mini_project.dto.UserVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository extends HttpServlet {//DB연관 클래스
    private final SqlSessionTemplate oracleSqlSessionTemplate;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("진입");
        UserVO user = oracleSqlSessionTemplate.selectOne("links.getUserById", userName);

        return user;
    }
}
