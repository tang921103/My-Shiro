package com.demo.service;

import com.demo.dao.UserMapper;
import com.demo.entities.User;
import com.demo.entities.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserService implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> findAll(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userMapper.selectByExample(userExample);
    }
}
