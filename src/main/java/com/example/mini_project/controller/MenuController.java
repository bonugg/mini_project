package com.example.mini_project.controller;

import com.example.mini_project.link_user.LinkTable;
import com.example.mini_project.link_user.SessionUser;
import com.example.mini_project.oauth.UserLikeRepository;
import com.example.mini_project.oauth.UserRepository;
import com.example.mini_project.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MenuController {
    @Autowired
    private LinkService linkService;
    @Autowired
    private HttpSession httpSession;
    private final UserRepository userRepository;
    private final UserLikeRepository userLikeRepository;

    @GetMapping("/bestLink")
    public String bestLink(Model model){
        if (httpSession.getAttribute("user") != null) {
            SessionUser user = (SessionUser) httpSession.getAttribute("user");
            user.setUsername(userRepository.findUsername_str(user.getNo()));
            model.addAttribute("user", user);
        }
        List<LinkTable> linkBestList = linkService.getbestLinkList();
        model.addAttribute("linkBestList", linkBestList);
        List<LinkTable> linkBestList2 = linkService.getbestLinkList2();
        System.out.println(linkBestList2);
        model.addAttribute("linkBestList2", linkBestList2);
        return "bestLinkPage";
    }
}
