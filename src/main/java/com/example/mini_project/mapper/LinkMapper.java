package com.example.mini_project.mapper;

import com.example.mini_project.link_user.LinkTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LinkMapper {
    List<LinkTable> getLinkList(long no); // 링크 리스트 가져오기
    List<LinkTable> getbestLinkList(); // 베스트 링크 리스트 가져오기
    List<LinkTable> getbestLinkList2(); // 베스트 링크 리스트 가져오기
    List<LinkTable> getdateLinkList(); // 시간 순으로 링크 리스트 가져오기

    void addLink(LinkTable linkTable); // 링크 추가

    void delLink(int LID); // 링크 삭제

    List<Map<String, Object>>autocomplete(Map<String, Object> paramMap) throws Exception;
}
