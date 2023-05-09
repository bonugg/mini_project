package com.example.mini_project.controller;

import com.example.mini_project.link.LinkTable;
import com.example.mini_project.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping("/add")
    public String addLink(LinkTable linkTable){
        if(!(linkTable.getLINK().contains("https://")) && !(linkTable.getLINK().contains("http://"))){
            linkTable.setLINK("http://".concat(linkTable.getLINK()));
        }
        linkService.addLink(linkTable);
        return "redirect:/";
    }

    @GetMapping("/delete_link")
    public String delLink(@RequestParam("LID") int LID){
        linkService.delLink(LID);
        return "redirect:/";
    }


}
