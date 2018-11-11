package com.tedu.service;

import com.tedu.bean.User;
import com.tedu.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserService implements IUserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User getUser(String username) {
        return userMapper.selectByUsername(username);
    }
}
