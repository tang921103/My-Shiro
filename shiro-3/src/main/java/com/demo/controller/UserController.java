package com.demo.controller;

import com.demo.entities.User;
import com.demo.service.IUserService;
import com.demo.utils.MessageUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private IUserService userService;
    @RequestMapping("/login.do")
    @ResponseBody
    public Map<String,Object> login(String username,String password){
        Map<String,Object> map = MessageUtil.getErrorMSg(null);
        System.out.println("login");
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            map = MessageUtil.getRightMSg(null);
        }catch (UnknownAccountException e){
            map = MessageUtil.getErrorMSg(null);
        }catch(IncorrectCredentialsException e){
            map = MessageUtil.getErrorMSg(null);
            System.out.println("密码不对");
        }catch(AuthenticationException e){
            map = MessageUtil.getErrorMSg(null);
        }
        return  map;
    }
    @RequestMapping("/showIndex.do")
    public String index(){
        return "index";
    }
    @RequestMapping("/showLogin.do")
    public String showLogin(){
        return "login";
    }
    @RequestMapping("/success.do")
    public String showSuccess(){
        return "success";
    }
}
