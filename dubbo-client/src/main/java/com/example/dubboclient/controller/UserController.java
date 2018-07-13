package com.example.dubboclient.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.entity.User;
import com.example.api.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;
    
    @RequestMapping(value = "/login")
    public String login(User user, Model model) {
        model.addAttribute("user", userService.get(new User("c", "n", 1)));
        return "index";
    }
}
