package com.tedu;

import com.tedu.bean.User;
import com.tedu.dao.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.annotation.Resource;

public class Test {

    @org.junit.Test
    public void testSelect(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
        UserMapper as = ac.getBean("userMapper", UserMapper.class);
        User user = as.selectByUsername("tom");
        System.out.println(user);
    }
}
