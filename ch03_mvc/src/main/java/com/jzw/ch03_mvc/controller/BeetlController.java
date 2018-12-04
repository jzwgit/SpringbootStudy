package com.jzw.ch03_mvc.controller;

import com.jzw.ch03_mvc.entity.User;
import com.jzw.ch03_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/beetl")
public class BeetlController {

    @Autowired
    UserService userService;
    @GetMapping("/showuser.html")
    public ModelAndView showUserInfo(int id){
        ModelAndView mav = new ModelAndView();
        User user = userService.getUser(id);
        mav.addObject("user",user);
        mav.setViewName("/userInfo.btl");
        return mav;
    }

    @GetMapping("/user/{id}.json")
    @ResponseBody
    public User showUserInfo2(@PathVariable int id){
        User user = userService.getUser(id);
        return user;
    }

    @GetMapping("/now.json")
    @ResponseBody
    public Map now(){
        Map map = new HashMap();
        map.put("time",new Date());
        return map;
    }

    //访问首页
    @RequestMapping("/user/index.html")
    public String index(int userId, Model model){
        User user = userService.getUser(userId);
        model.addAttribute("user",user);
        return "/index.btl";
    }

    //登陆成功后，携带参数重定向到index页面
    @RequestMapping("/user/login.html")
    public String login(int id){
        User user = userService.getUser(id);
        if(user != null){
            //第一种写法
            //return "redirect:/beetl/user/index.html?userId="+id;
            //第二种写法
//            ModelAndView mav = new ModelAndView("redirect:/beetl/user/index.html?userId="+id);
            //第三种写法
            RedirectView rv = new RedirectView("/beetl/user/index.html?userId="+id);
        }
        return null;
    }
}
