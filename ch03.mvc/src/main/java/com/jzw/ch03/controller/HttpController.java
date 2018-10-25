package com.jzw.ch03.controller;

import com.jzw.ch03.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/http")
public class HttpController {
    @GetMapping("/update.json")
    @ResponseBody
    public String updateUser(User user){
        return "success";
    }

}
