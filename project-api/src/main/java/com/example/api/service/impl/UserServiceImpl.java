package com.example.api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.dao.user.UserDao;
import com.example.api.entity.User;
import com.example.api.service.CrudService;
import com.example.api.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends CrudService<UserDao, User> implements UserService {
    
    @Override
    public User get(User user) {
        return user;
    }

}
