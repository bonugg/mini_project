package com.mini_project.repository;

import com.mini_project.dto.LinkTable;
import com.mini_project.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LinkRepository extends HttpServlet {//DB연관 클래스
    private final SqlSessionTemplate oracleSqlSessionTemplate;

    public void save(LinkTable link){
        LinkTable linkTable = new LinkTable();
        linkTable.link_rs(link.getLINK());
        if(!(linkTable.getLINK().equals("유효하지 않은 링크"))){
            oracleSqlSessionTemplate.insert("links.save_tci", linkTable);
        }else {
        }
    }
    public List<LinkTable> findAll(){
        return oracleSqlSessionTemplate.selectList("links.show");
    }
    public void delete(int ID) {
        oracleSqlSessionTemplate.delete("links.delete", ID);
    }

    public void signin(UserDTO userDTO) {
        oracleSqlSessionTemplate.insert("links.signin", userDTO);
    }

    public UserDTO login(UserDTO userDTO) {
        return oracleSqlSessionTemplate.selectOne("links.login", userDTO);
    }
}
