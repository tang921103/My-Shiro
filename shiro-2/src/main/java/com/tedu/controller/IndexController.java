package com.tedu.controller;

import com.tedu.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    /**
     * 主页
     * @return
     */
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
    @RequestMapping("/toLogin.do")
    public String toLogin(User user){
        System.out.println("user:"+user);
        String username = user.getUsername();
        String password = user.getPassword();
//        SimpleHash sh = new SimpleHash("MD5",password,null,1024);
//        System.out.println(password);
        Subject subject = SecurityUtils.getSubject();
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)){
            if(!subject.isAuthenticated()){
                UsernamePasswordToken token = new UsernamePasswordToken(username,password);
                try{
                    /*
                     *密码比对由shiro帮我们完成：
                     * 1：token封装的是用户输入的用户名和密码
                     * 2：SimpleAuthenticationInfo中封装的是从数据库中查询到的用户名和密码
                     */
                    subject.login(token);
                    System.out.println(token.getPassword());
                }catch(AuthenticationException e){
                    System.out.println("登陆失败");
                    return "error";
                }
            }
        }
        return "success";
    }

}
