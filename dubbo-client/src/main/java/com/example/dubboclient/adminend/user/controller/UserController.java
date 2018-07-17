package com.example.dubboclient.adminend.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.example.api.controller.BaseController;
import com.example.api.entity.user.User;
import com.example.api.service.user.UserService;

/**
 * 管理员用户Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/admin/u")
public class UserController extends BaseController{
    
    @Reference
    private UserService userService;
    
    private final String LOGIN_PAGE = "user/login";
    
    private final String REGISTER_PAGE = "user/register";
    
    /**
     * 登录页面 登录提交
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(User user) {
        if(user == null || StringUtils.isBlank(user.getAccount()) && StringUtils.isBlank(user.getPassword())) {
            return getAdminView(LOGIN_PAGE);
        } else {
            return "";
        }
    }
    
    /**
     * 注册页面 注册提交
     * @param user
     * @return
     */
    @RequestMapping(value = "/register")
    public String register(User user) {
        if(user == null || StringUtils.isBlank(user.getAccount()) && StringUtils.isBlank(user.getPassword())) {
            return getAdminView(REGISTER_PAGE);
        } else {
            return "";
        }
    }

}
