package com.example.dubboclient.adminend.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.common.utils.StringUtils;

@Controller
@RequestMapping(value = "/admin/u")
public class UserController {
    
    private static final String LOGIN_REGISTER = "/adminend/";
    
    @RequestMapping(value = "/{type}")
    public String view(@PathVariable("type") String type) {
        if(StringUtils.isBlank(type)) {
            
        } else {
            type = type.toLowerCase();
        }
        return LOGIN_REGISTER + type;
    }

}
