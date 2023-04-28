package com.mini_project.repository;

import com.mini_project.dto.LinkDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LinkRepository {//DB연관 클래스
    private final SqlSessionTemplate oracleSqlSessionTemplate;
    public void save(String linkDTO) {
        LinkDTO l = new LinkDTO();
        l.link_rs(linkDTO);
        System.out.println(l);
        oracleSqlSessionTemplate.insert("links.save_tci", l);
    }
    public List<LinkDTO> findAll(){
        return oracleSqlSessionTemplate.selectList("links.show");
    }
    public void delete(String link) {
        oracleSqlSessionTemplate.delete("links.delete", link);
    }
}
