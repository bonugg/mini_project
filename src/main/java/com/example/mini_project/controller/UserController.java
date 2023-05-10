package com.example.mini_project.controller;

import com.example.mini_project.link.LinkTable;
import com.example.mini_project.oauth.SessionUser;
import com.example.mini_project.service.LinkService;
import com.example.mini_project.service.UserService;
import com.example.mini_project.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/")
    public String home(Model model) { //로그인 성공 시 출력 페이지
        if((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null){
            String id = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println(id);
            UserVo userVo = userService.getUserById(id);
            userVo.setPassword(null);
            model.addAttribute("user", userVo);
            List<LinkTable> linkTableList = linkService.getLinkList(id);
            model.addAttribute("linkList", linkTableList);
            return "home";
        }
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        System.out.println(user.getEmail());
        System.out.println(user.getName());
        model.addAttribute("user", user);
        List<LinkTable> linkTableList = linkService.getLinkList(user.getEmail());
        model.addAttribute("linkList", linkTableList);
        return "home";
    }

    @GetMapping("/userList")
    public String getUserList(Model model) {
        List<UserVo> userList = userService.getUserList();
        model.addAttribute("list", userList);
        return "userListPage";
    }

    @GetMapping("/login")
    public String loginPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken)
            return "loginPage";
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signupPage() {  // 회원 가입 페이지
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken)
            return "signupPage";
        return "redirect:/";
    }

    @PostMapping("/signup")
    public String signup(UserVo userVo) { // 회원 가입
        try {
            userService.signup(userVo);
        } catch (DuplicateKeyException e) {
            return "redirect:/signup?error_code=-1";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/signup?error_code=-99";
        }
        return "redirect:/login";
    }

    @GetMapping("/update")
    public String editPage(Model model) { // 회원 정보 수정 페이지
        String id = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo userVo = userService.getUserById(id);
        model.addAttribute("user", userVo);
        return "editPage";
    }

    @PostMapping("/update")
    public String edit(UserVo userVo) { // 회원 정보 수정
        String id = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userVo.setId(id);
        userService.edit(userVo);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String withdraw(HttpSession session) { // 회원 탈퇴
        String id = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (id != null) {
            userService.withdraw(id);
        }
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }
}
