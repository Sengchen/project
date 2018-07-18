package com.example.dubboclient.frontend.index.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.controller.BaseController;
import com.example.api.entity.user.User;

@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController{
    
    private final String FRONT_USER_LOGIN = getFrontView("user/login");
    
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/login")
    public String login(@AuthenticationPrincipal User loginedUser) {
        if(loginedUser != null) {
            
        }
        return FRONT_USER_LOGIN;
    }
    
}