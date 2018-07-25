package com.example.dubboclient.config;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.api.entity.Constants;

/**
 * 拦截器
 * 
 * @author Administrator
 *
 */
@Component
public class MyInterceptor implements HandlerInterceptor {

    /*
     * @Autowired private RedisUtil redisUtil;
     */
    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            String username;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else  if(principal instanceof Principal) {
                username = ((Principal) principal).getName();
            } else {
                username = String.valueOf(principal);
            }
            request.setAttribute("username", username);
        }
        request.setAttribute("ctx", Constants.contextPath);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
