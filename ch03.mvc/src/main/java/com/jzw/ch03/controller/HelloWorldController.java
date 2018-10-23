package com.jzw.ch03.controller;

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
    @RequestMapping("/index.btl")
    public String say(Model model) {
        model.addAttribute("name", "Hello,world !");
        return "/index.btl";
    }

    @RequestMapping("/index.json")
    public @ResponseBody String say(){
        return "Hello world";
    }
    @RequestMapping(path = "/all.json",method = RequestMethod.GET)
    public @ResponseBody List<String> allUser(){
        List<String> strs = new ArrayList<String>();
        strs.add("张三");
        strs.add("李四");
        return strs;
    }
}
