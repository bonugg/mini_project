package com.mini_project.repository;

import com.mini_project.dto.LinkTable;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LinkRepository {//DB연관 클래스
    private final SqlSessionTemplate oracleSqlSessionTemplate;
    public void save(LinkTable link) {
        LinkTable linkTable = new LinkTable();
        linkTable.link_rs(link.getLINK());
        oracleSqlSessionTemplate.insert("links.save_tci", linkTable);
    }
    public List<LinkTable> findAll(){
        System.out.println(oracleSqlSessionTemplate.selectList("links.show"));
        return oracleSqlSessionTemplate.selectList("links.show");
    }
    public void delete(int ID) {
        oracleSqlSessionTemplate.delete("links.delete", ID);
    }
}
