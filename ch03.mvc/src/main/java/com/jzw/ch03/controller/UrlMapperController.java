package com.jzw.ch03.controller;

import com.jzw.ch03.entity.User;
import com.jzw.ch03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/json")
public class UrlMapperController {
    @Autowired
    UserService userService;

    @RequestMapping("/get/{id}.json")
    @ResponseBody
    public User getById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/{id}.json")
    @ResponseBody
    public User getByid2(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @RequestMapping(path = "/user/all.json",method = RequestMethod.GET)
    public @ResponseBody List<User> allUser(){
        return userService.allUser();
    }

    @GetMapping("/user/all/*.json")
    @ResponseBody
    public List<User> allUser2(){
        return userService.allUser();
    }

    @GetMapping(value = "/consumes/test.json",consumes = "application/json")
    @ResponseBody
    public User forJson(){
        return userService.getUserById(1l);
    }

    /**
     * ${}来获得系统的配置或者环境变量，通常用于Controller路径是通过配置文件设定的情况
     * @return
     */
//    @RequestMapping("/${querry.all}.json")
//    @ResponseBody
//    public List<User> all(){
//        return userService.allUser();
//    }


}
