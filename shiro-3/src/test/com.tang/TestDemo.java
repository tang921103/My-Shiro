package com.tang;

import com.demo.dao.UserMapper;
import com.demo.entities.User;
import com.demo.entities.UserExample;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDemo {
    @Test
    public void test1(){
        AbstractApplicationContext aa = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = aa.getBean("userMapper",UserMapper.class);
        UserExample userExample = new UserExample();
        List<User> list = userMapper.selectByExample(userExample);
        System.out.println(list);
     }
}
