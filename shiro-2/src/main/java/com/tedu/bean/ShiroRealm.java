package com.tedu.bean;

import com.tedu.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;

import javax.annotation.Resource;

//Realm从数据库中查询数据
public class ShiroRealm extends AuthenticatingRealm {
    @Resource
    private IUserService userService;
    /**
     * 1.返回AuthenticationInfo的实现类SimpleAuthenticationInfo
     * 2.容器会把登陆时的token传到这里。此处需要强制转化
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SimpleAuthenticationInfo simpleAuthenticationInfo= null;
            User user = userService.getUser(token.getUsername());
            String password = user.getPassword();
            SimpleHash sh = new SimpleHash("MD5",password,null,1024);
            if (user != null) {
                simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), sh, this.getName());
            } else {
                throw new UnknownAccountException();
            }
        return simpleAuthenticationInfo;
    }
}
