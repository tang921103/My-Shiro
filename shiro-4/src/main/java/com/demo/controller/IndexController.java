package com.demo.controller;

import com.demo.entities.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/main")
    public String showLogin(){
        System.out.println("login");
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(UserEntity userEntity){
        System.out.println(userEntity);
        UsernamePasswordToken token = new UsernamePasswordToken(userEntity.getUsername(),userEntity.getPassword());
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            subject.login(token);
        }
        return "success";
    }
}
