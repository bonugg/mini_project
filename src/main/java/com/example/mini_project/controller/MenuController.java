package com.example.mini_project.controller;

import com.example.mini_project.link_user.LinkTable;
import com.example.mini_project.link_user.SessionUser;
import com.example.mini_project.link_user.User;
import com.example.mini_project.link_user.UserInterface;
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
        model.addAttribute("linkBestList2", linkBestList2);
        return "bestLinkPage";
    }

    @GetMapping("/bestUser")
    public String bestUser(Model model){
        if (httpSession.getAttribute("user") != null) {
            SessionUser user = (SessionUser) httpSession.getAttribute("user");
            user.setUsername(userRepository.findUsername_str(user.getNo()));
            model.addAttribute("user", user);
        }
        List<User> bestUser = userRepository.bestLikeList();
        model.addAttribute("bestUser", bestUser);
        List<UserInterface> bestUser2 = userRepository.bestLikeList2();
        System.out.println(bestUser2.get(0).getRn());
        model.addAttribute("bestUser2", bestUser2);

        List<LinkTable> linkBestList2 = linkService.getbestLinkList2();
        model.addAttribute("linkBestList2", linkBestList2);
        return "bestUserPage";
    }

    @GetMapping("/dateLink")
    public String dateLink(Model model){
        if (httpSession.getAttribute("user") != null) {
            SessionUser user = (SessionUser) httpSession.getAttribute("user");
            user.setUsername(userRepository.findUsername_str(user.getNo()));
            model.addAttribute("user", user);
        }
        List<LinkTable> linkDateList = linkService.getdateLinkList();
        for (int i = 0; i < linkDateList.size(); i++) {
            linkDateList.get(i).setUsername(userRepository.findByUsername(linkDateList.get(i).getNO()));
        }
        model.addAttribute("linkDateList", linkDateList);
        return "todayLinkPage";
    }
}
