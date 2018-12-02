package com.demo.config;

import com.demo.entities.User;
import com.demo.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Resource
    private IUserService userService;

    /**
     * 认证realm
     * @param token
     * @return
     * @throws AuthenticationException
     */
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

    /**
     * 授权realm
     * 从数据库中获取对应用户名的角色
     * principals 用户名
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = null;
        List<User> list = userService.findAll(principals.toString());
        if(null != list && list.size() > 0){
            User user = list.get(0);
            String roles = user.getRoles();
            Set<String> set = new HashSet<String>();
            set.add(roles);
            simpleAuthorizationInfo = new SimpleAuthorizationInfo(set);
        }
        return simpleAuthorizationInfo;
    }
}
