package com.example.mini_project.service;

import com.example.mini_project.links.LinkTable;
import com.example.mini_project.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {
    @Autowired
        private LinkMapper linkMapper;

    public List<LinkTable> getLinkList(String email) {
        return linkMapper.getLinkList(email);
    } //링크리스트 출력

    public void addLink(LinkTable linkTable) { // 링크추가
        linkTable.link_rs(linkTable.getLINK());
        linkMapper.addLink(linkTable);
    }

    public void delLink(int LID){
        linkMapper.delLink(LID);
    } //링크삭제
}
