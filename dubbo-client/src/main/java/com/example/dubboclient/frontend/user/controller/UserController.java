package com.example.dubboclient.frontend.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.controller.BaseController;

@Controller
@RequestMapping(value = "/u")
public class UserController extends BaseController{
    
    private final String FRONT_USER_HOME = getFrontView("user/home");

    
    
    @RequestMapping(value = "/home")
    public String home() {
        return FRONT_USER_HOME;
    }
}
