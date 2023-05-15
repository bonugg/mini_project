package com.example.mini_project.service;

import com.example.mini_project.link_user.LinkTable;
import com.example.mini_project.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LinkService {
    @Autowired
        private LinkMapper linkMapper;

    public List<LinkTable> getLinkList(long no) {
        return linkMapper.getLinkList(no);
    } //링크리스트 출력

    public void addLink(LinkTable linkTable) { // 링크추가
        linkTable.link_rs(linkTable.getLINK());
        if(!(linkTable.getLINK().equals("유효하지 않은 링크")))
            linkMapper.addLink(linkTable);
    }

    public void delLink(int LID){
        linkMapper.delLink(LID);
    } //링크삭제

    public List<Map<String, Object>>autocomplete(Map<String, Object> paramMap) throws Exception{
        return linkMapper.autocomplete(paramMap);
    }


}
