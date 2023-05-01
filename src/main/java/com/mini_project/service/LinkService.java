package com.mini_project.service;

import com.mini_project.dto.LinkTable;
import com.mini_project.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepository linkRepository;

    public void save(LinkTable linkTable) {
        linkRepository.save(linkTable);
    }
    public List<LinkTable> findAll(){
        return linkRepository.findAll();
    }

    public void delete(int ID) {
        linkRepository.delete(ID);
    }
}
