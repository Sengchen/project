package com.example.dubboclient.adminend.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.example.api.controller.BaseController;
import com.example.api.entity.User;
import com.example.api.service.UserService;

@Controller
@RequestMapping(value = "/admin/u")
public class UserController extends BaseController{
    
    @Resource
    private UserService userService;
    
    private final String LOGIN_PAGE = "user/login";
    
    private final String REGISTER_PAGE = "user/register";
    
    @RequestMapping(value = "/login")
    public String login(User user) {
        userService.get(user);
        if(user == null || StringUtils.isBlank(user.getAccount()) && StringUtils.isBlank(user.getPassword())) {
            return getAdminView(LOGIN_PAGE);
        } else {
            return "";
        }
    }
    
    @RequestMapping(value = "/register")
    public String register(User user) {
        if(user == null || StringUtils.isBlank(user.getAccount()) && StringUtils.isBlank(user.getPassword())) {
            return getAdminView(REGISTER_PAGE);
        } else {
            return "";
        }
    }

}
