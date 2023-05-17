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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        user.setUsername(userRepository.findUsername(user.getNo()));
        model.addAttribute("user", user);
        List<LinkTable> linkTableList = linkService.getLinkList(user.getNo());
        model.addAttribute("linkList", linkTableList);
        return "mainPage";
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

    @ResponseBody
    @RequestMapping(value = "/idCheck", method = RequestMethod.POST) //아이디 중복체크
    public int IdCheck(@RequestBody String id) throws Exception {
        int count = 0;
        if (id != null)
            count = userRepository.idCheck(id);
        return count;
    }

    @GetMapping("/update")
    public String editPage(Model model) { // 회원 정보 수정 페이지
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        model.addAttribute("user", sessionUser);
        return "editPage";
    }

    @PostMapping("/update")
    public String edit(User user) { // 회원 정보 수정
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String withdraw() { // 회원 탈퇴
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        userRepository.deleteById(user.getNo());
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }

    @GetMapping("/user_search")
    public String userSearchPage(String username, Model model) { // 검색 리스트 출력 페이지
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        user.setUsername(userRepository.findUsername(user.getNo()));
        model.addAttribute("user", user);
        List<User> userList = userRepository.findByUsernameContaining(username);
        model.addAttribute("userList", userList);
        return "searchPage";
    }

    @GetMapping("/user_link")
    public String showUserLink(@RequestParam("no") long no, Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user.getNo() == no) {
            return "redirect:/";
        }
        user.setUsername(userRepository.findUsername(user.getNo()));
        model.addAttribute("user", user);
        List<LinkTable> linkTableList = linkService.getLinkList(no);
        model.addAttribute("linkList", linkTableList);
        return "showUserLinkPage";
    }

    @RequestMapping(value = "/get/test")
    public @ResponseBody Map<String, Object> autocomplete(@RequestParam Map<String, Object> paramMap) throws Exception {
        List<Map<String, Object>> resultList = linkService.autocomplete(paramMap);
        paramMap.put("resultList", resultList);
        return paramMap;
    }
}
