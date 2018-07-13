package com.example.api.service.impl;

import org.springframework.stereotype.Service;

import com.example.api.entity.User;
import com.example.api.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Override
    public User get(User user) {
        return user;
    }

}
