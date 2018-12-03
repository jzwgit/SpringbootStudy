package com.jzw.ch02_aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        String s = "hello world! by "+name;
        System.out.println(s);
        return s;
    }
}
