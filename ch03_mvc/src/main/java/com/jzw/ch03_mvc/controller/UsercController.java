package com.jzw.ch03_mvc.controller;

import com.jzw.ch03_mvc.entity.User;
import com.jzw.ch03_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UsercController {

    @Autowired
    UserService userService;

    @GetMapping("/all/*.json")
    @ResponseBody
    public List<User> allUser(){
        return userService.allUser();
    }

    @GetMapping("/{userId}/get.html")
    public String getUser(@PathVariable int userId, Model model){
        User userInfo = userService.getUser(userId);
        model.addAttribute("user",userInfo);
        return "/userInfo.btl";
    }

    @GetMapping("/{userId}/get2.html")
    public ModelAndView getUser2(@PathVariable int userId, ModelAndView mav){
        User userInfo = userService.getUser(userId+1);
        mav.addObject("user",userInfo);
        mav.setViewName("/userInfo.btl");
        return mav;
    }

    @GetMapping("/update.json")
    public String setUser(@RequestParam(name = "id", required = true)int id, String name, Model model){
        User user = new User(id,name);
        System.out.println(user);
        model.addAttribute("user",user);
        return "/userInfo.btl";
    }

    @PostMapping("/save.json")
    @ResponseBody
    public String saveOrderByJson(@RequestBody User user){
        return user.getName();
    }
}
