package com.mini_project.controller;

import com.mini_project.dto.LinkTable;
import com.mini_project.dto.UserDTO;
import com.mini_project.service.KakaoService;
import com.mini_project.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member") //공통주소
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;
    private final KakaoService kakaoService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/add")
    public String saveForm(){
        return "redirect:/member/list";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute LinkTable linkTable){
        if(!(linkTable.getLINK().contains("https://")) && !(linkTable.getLINK().contains("http://"))){
            linkTable.setLINK("http://".concat(linkTable.getLINK()));
        }
        linkService.save(linkTable);
        return "redirect:/member/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("ID") int ID){
        linkService.delete(ID);
        return "redirect:/member/list";
    }

    @GetMapping("/list")
    public String findAll(Model model, HttpSession session){
        String mId = (String) session.getAttribute("M_ID");
        List<LinkTable> linkTableList = linkService.findAll(mId);
        model.addAttribute("linkList", linkTableList);
        return "list";
    }

    @GetMapping("/signin")
    public String signin(){
        return "signin";
    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute UserDTO userDTO){
        userDTO.setM_PWD(passwordEncoder.encode(userDTO.getM_PWD()));
        System.out.println(userDTO);
        linkService.signin(userDTO);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("M_ID", null);
        session.setMaxInactiveInterval(0);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/kakao")
    public void  kakaoCallback(@RequestParam String code){
        String access_Token = kakaoService.getKakaoAccessToken(code);
        kakaoService.createKakaoUser(access_Token);
    }

    @RequestMapping(value="/")
    public String page() throws Exception {
        return "index";
    }
}
