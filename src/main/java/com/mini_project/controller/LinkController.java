package com.mini_project.controller;

import com.mini_project.dto.LinkDTO;
import com.mini_project.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member") //공통주소
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;

    @GetMapping("/add")
    public String saveForm(@RequestParam("link") String link){
        System.out.println(link);
        linkService.save(link);
        return "redirect:/member/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("link") String link){
        linkService.delete(link);
        return "redirect:/member/list";
    }

    @GetMapping("/list")
    public String findAll(Model model){
        List<LinkDTO> linkDTOList = linkService.findAll();
        model.addAttribute("linkList", linkDTOList);
        return "list";
    }


}
