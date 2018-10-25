package com.jzw.ch03.controller;

import com.jzw.ch03.entity.User;
import com.jzw.ch03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class HelloWorldController {

    @Autowired
    UserService userService;

    @RequestMapping("/index.btl")
    public String say(Model model) {
        model.addAttribute("name", "Hello,world !");
        return "/index.btl";
    }

    @RequestMapping("/index.json")
    public @ResponseBody String say(){
        return "Hello world";
    }

}
