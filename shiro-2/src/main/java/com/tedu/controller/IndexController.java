package com.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index.do")
    public String showIndex(){
        System.out.println("index");
        return "index";
    }
    @RequestMapping("/login.do")
    public String showLogin(){
        return "login";
    }
    @RequestMapping("/test.do")
    public String success(){
        return "test";
    }
}
