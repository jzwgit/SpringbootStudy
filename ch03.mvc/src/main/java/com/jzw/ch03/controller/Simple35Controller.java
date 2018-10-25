package com.jzw.ch03.controller;

import com.jzw.ch03.entity.User;
import com.jzw.ch03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/{id}")
public class Simple35Controller {
    @Autowired
    UserService userService;

    @GetMapping(path = "/{type}/get.json")
    @ResponseBody
    public User getUser(@PathVariable Long id,@PathVariable Integer type){
        return userService.getUserById(id);
    }
}
