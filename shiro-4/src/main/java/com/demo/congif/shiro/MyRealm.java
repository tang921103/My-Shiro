package com.demo.congif.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {
    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 身份校验
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String name = (String)token.getPrincipal();
        SimpleHash simpleHash = new SimpleHash("MD5","123456",null,1024);
        //传入比对信息, getName()获取当前的realm
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("tangqiu",simpleHash,getName());
        return simpleAuthenticationInfo;
    }
}
