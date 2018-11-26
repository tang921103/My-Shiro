package com.demo.service;

import com.demo.entities.User;

import java.util.List;

public interface IUserService {
    List<User> findAll(String username);
}
