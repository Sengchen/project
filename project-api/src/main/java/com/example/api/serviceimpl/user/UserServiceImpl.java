package com.example.api.serviceimpl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.dao.user.UserDao;
import com.example.api.entity.user.User;
import com.example.api.service.CrudService;
import com.example.api.service.user.UserService;

@Service
@Transactional
@com.alibaba.dubbo.config.annotation.Service(version = "0.0.1")
public class UserServiceImpl extends CrudService<UserDao, User> implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public User get(User user) {
        
        return userDao.get(user);
    }

}
