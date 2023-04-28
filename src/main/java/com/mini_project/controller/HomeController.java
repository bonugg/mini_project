package com.mini_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class  HomeController {
    @GetMapping("/")
    public String index(){
        return "index"; // > index.jsp 출력
    }
}
