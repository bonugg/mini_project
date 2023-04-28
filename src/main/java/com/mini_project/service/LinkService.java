package com.mini_project.service;

import com.mini_project.dto.LinkDTO;
import com.mini_project.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepository linkRepository;

    public void save(String linkDTO) {
        linkRepository.save(linkDTO);
    }
    public List<LinkDTO> findAll(){
        return linkRepository.findAll();
    }

    public void delete(String link) {
        linkRepository.delete(link);
    }
}
