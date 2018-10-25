package com.jzw.ch03.controller;

import com.jzw.ch03.entity.User;
import com.jzw.ch03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mav")
public class MAVController {

    @Autowired
    UserService userService;

    @GetMapping("/{userId}/get.html")
    public String getUser(@PathVariable Long userId, Model model){
        User userInfo = userService.getUserById(userId);
//        model.addAttribute(userInfo);
        model.addAttribute("user",userInfo);
        return "/userInfo.btl";
    }

    @RequestMapping("/{userId}/get2.html")
    public ModelAndView getUser2(@PathVariable Long userId,ModelAndView view){
        User userInfo = userService.getUserById(userId);
        view.addObject("user",userInfo);
        view.setViewName("/userInfo.btl");
        return view;
    }
}
