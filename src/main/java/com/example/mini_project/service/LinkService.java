package com.example.mini_project.service;

import com.example.mini_project.link.LinkTable;
import com.example.mini_project.mapper.LinkMapper;
import com.example.mini_project.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {
    @Autowired
        private LinkMapper linkMapper;

    public List<LinkTable> getLinkList(String id) {
        return linkMapper.getLinkList(id);
    }

    public void addLink(LinkTable linkTable) { // 회원 가입
        linkTable.link_rs(linkTable.getLINK());
        System.out.println(linkTable);
        linkMapper.addLink(linkTable);
    }

    public void delLink(int LID){
        linkMapper.delLink(LID);
    }
}
