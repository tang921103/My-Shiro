package com.demo.controller;

import com.demo.entities.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
    @RequestMapping("/not")
    public String notFound(){
        return "404";
    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    @RequestMapping("/hello")
    @RequiresRoles(value={"admin"})
    public String hello(){
        return "hello";
    }
    @RequestMapping("/world")
    @RequiresPermissions(value={"query","delete"},logical = Logical.OR)
    public String world(){
        return "world";
    }
    @RequestMapping("/login")
    public String login(UserEntity userEntity){
        System.out.println(userEntity);
        UsernamePasswordToken token = new UsernamePasswordToken(userEntity.getUsername(),userEntity.getPassword());
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            try{
                subject.login(token);
                return "success";
            }catch(UnknownAccountException e){
                System.out.println("用户名不存在");
            }catch(IncorrectCredentialsException e){
                System.out.println("密码错误");
            }catch (AuthenticationException e){
                System.out.println("登录错误");
            }
        }else{
            return "success";
        }
        return "login";
    }
}
