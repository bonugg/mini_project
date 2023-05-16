package com.example.mini_project.controller;

import com.example.mini_project.link_user.LinkTable;
import com.example.mini_project.link_user.SessionUser;
import com.example.mini_project.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LinkController {
    @Autowired
    private LinkService linkService;

    @Autowired
    private HttpSession httpSession;

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

    @GetMapping("/myLinkAdd")
    public String myLinkAdd(@RequestParam("LINK") String LINK, @RequestParam("no") long no) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        LinkTable linkTable = new LinkTable();
        linkTable.setNO(user.getNo());
        linkTable.setLINK(LINK);
        linkService.addLink(linkTable);
        return "redirect:/user_link?no="+no;
    }


}
