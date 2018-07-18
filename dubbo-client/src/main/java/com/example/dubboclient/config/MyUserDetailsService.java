package com.example.dubboclient.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.api.entity.user.User;
import com.example.api.service.user.UserService;

/**
 * 自定义权限校验工具
 * @author Administrator
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        logger.info("用户的用户名: {}", account);

        User search = new User();
        search.setAccount(account);
        User user = userService.get(search);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // 用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        user.getRoles().stream().forEach(t -> authorities.add(new SimpleGrantedAuthority(t.getName())));

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        return new org.springframework.security.core.userdetails.User(user.getAccount(), user.getPassword(), authorities);
    }

}
