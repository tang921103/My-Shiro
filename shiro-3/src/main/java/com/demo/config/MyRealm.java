package com.demo.config;

import com.demo.entities.User;
import com.demo.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;

import javax.annotation.Resource;
import java.util.List;

public class MyRealm extends AuthenticatingRealm {
    @Resource
    private IUserService userService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken tok = (UsernamePasswordToken)token;
        SimpleAuthenticationInfo saf = null;
        String username = tok.getUsername();
        List<User> list = userService.findAll(username);
        if(null!=list && list.size()>0){
            User user = list.get(0);
            SimpleHash sh = new SimpleHash("MD5",user.getPassword(),null,1024);
            saf = new SimpleAuthenticationInfo(user.getUsername(),sh,this.getName());
        }else{
            throw new UnknownAccountException();
        }
        return saf;
    }
}
