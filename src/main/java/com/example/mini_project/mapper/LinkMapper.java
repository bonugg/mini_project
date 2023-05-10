package com.example.mini_project.mapper;

import com.example.mini_project.link.LinkTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LinkMapper {
    List<LinkTable> getLinkList(String email); // 링크 리스트 가져오기

    void addLink(LinkTable linkTable); // 링크 추가

    void delLink(int LID); // 링크 삭제
}
