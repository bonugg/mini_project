package com.mini_project.controller;

import com.mini_project.dto.LinkTable;
import com.mini_project.dto.UserDTO;
import com.mini_project.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member") //공통주소
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;

    @GetMapping("/add")
    public String saveForm(){
        return "redirect:/member/list";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute LinkTable linkTable){
        if(!(linkTable.getLINK().contains("https://")) || !(linkTable.getLINK().contains("http://"))){
            linkTable.setLINK("http://".concat(linkTable.getLINK()));
        }
        System.out.println(linkTable);
        linkService.save(linkTable);
        return "redirect:/member/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("ID") int ID){
        linkService.delete(ID);
        return "redirect:/member/list";
    }

    @GetMapping("/list")
    public String findAll(Model model){
        List<LinkTable> linkTableList = linkService.findAll();
        model.addAttribute("linkList", linkTableList);
        return "list";
    }

    @GetMapping("/signin")
    public String signin(){
        return "signin";
    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute UserDTO userDTO){
        linkService.signin(userDTO);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "redirect:/member/list";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session){
        boolean loginrs = linkService.login(userDTO);
        if(loginrs){
            session.setAttribute("M_ID",userDTO.getM_ID());
            return "list";
        }else {
            return "/";

        }

    }
}
