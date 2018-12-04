package com.jzw.ch03_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class HelloworldController {

    @RequestMapping("/index.html")
    public String say(Model model){
        model.addAttribute("name","hello,world");
        return "/index.btl";
    }
}
