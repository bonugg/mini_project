package com.example.mini_project.controller;

import com.example.mini_project.link_user.LinkTable;
import com.example.mini_project.link_user.SessionUser;
import com.example.mini_project.link_user.User;
import com.example.mini_project.oauth.UserRepository;
import com.example.mini_project.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private LinkService linkService;
    @Autowired
    private HttpSession httpSession;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/")
    public String home(Model model) { //로그인 성공 시 출력 페이지
        if( httpSession.getAttribute("user") == null){
            String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userRepository.findByEmailAndProvider(email, "linktree").get();
            user.setPassword(null);
            model.addAttribute("user", user);
            List<LinkTable> linkTableList = linkService.getLinkList(user.getNo());
            model.addAttribute("linkList", linkTableList);
            return "home";
        }else {
            SessionUser user = (SessionUser) httpSession.getAttribute("user");
            model.addAttribute("user", user);
            List<LinkTable> linkTableList = linkService.getLinkList(user.getNo());
            model.addAttribute("linkList", linkTableList);
            return "home";
        }
    }

//    @GetMapping("/userList")
//    public String getUserList(Model model) {
//        List<User> userList = userService.getUserList();
//        model.addAttribute("list", userList);
//        return "userListPage";
//    }

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
    public String signup(User user) { // 회원 가입
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
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
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmailAndProvider(email, "linktree").get();
        user = userRepository.findById(user.getNo()).get();
        model.addAttribute("user", user);
        return "editPage";
    }

    @PostMapping("/update")
    public String edit(User user) { // 회원 정보 수정
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String withdraw() { // 회원 탈퇴
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmailAndProvider(email, "linktree").get();
        userRepository.deleteById(user.getNo());
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }
}
