package com.example.dubboclient.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.entity.User;
import com.example.api.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;
    
    public String login(User user) {
        return "";
    }
}
