package com.jzw.ch01_hello.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RESTful(多系统调用)测试
 */
@RestController //可以看成@Controller+@ResponseBody
public class UserReditRestController {
    @RequestMapping("/user/{id}")
    public Integer getCreditLevel(@PathVariable String id){
        //模拟id用户的信用等级
        return 3;
    }
}
