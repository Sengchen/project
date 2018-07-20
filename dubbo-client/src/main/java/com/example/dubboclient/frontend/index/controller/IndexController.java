package com.example.dubboclient.frontend.index.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.api.controller.BaseController;
import com.example.api.entity.user.User;

@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController {

    private final String FRONT_USER_LOGIN = getFrontView("user/login");

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(User user, HttpServletRequest request) {
        if (user != null) {

        }
        return "index";
    } 

}