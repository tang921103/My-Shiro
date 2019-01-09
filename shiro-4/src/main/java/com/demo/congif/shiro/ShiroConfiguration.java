package com.demo.congif.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 配置类
 */
@Configuration
public class ShiroConfiguration {
    /**
     * shiro核心
     * securityManager 安全管理器
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //注入自定义安全数据源
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    /**
     * 自定义安全数据源
     * @return
     */
    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        //注入加密器
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myRealm;
    }

    /**
     * 加密器
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //MD5加密方式
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /**
     * shiro的过滤器
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //注入安全管理器securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        //没有登录时跳转
        shiroFilterFactoryBean.setLoginUrl("/index");
        //登录成功
        shiroFilterFactoryBean.setSuccessUrl("/success");
        //没有权限时访问
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        //自定义过滤条件
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("index","anon");
        filterChainDefinitionMap.put("/**","authc");
        return shiroFilterFactoryBean;
    }
}