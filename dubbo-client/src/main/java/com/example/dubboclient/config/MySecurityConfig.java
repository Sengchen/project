package com.example.dubboclient.config;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring-boot-security
 * @author Administrator
 *
 */
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // 定义哪些URL需要被保护, 哪些不需要被保护
            .anyRequest() // 任何请求, 登录后可以访问
            .authenticated() // 任何请求, 登录后可以访问
            .and()
            .formLogin() // 定义当需要用户登录时候，转到的登录页面。
            .loginPage("/login")
            .failureUrl("/login?error")
            .permitAll() // 登录页面用户任意访问
            .and()
            .logout()
            .permitAll(); // 注销行为任意访问
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Encoder.encode(((String) rawPassword).getBytes());
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Encoder.encode(((String) rawPassword).getBytes()));
            }
        });
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/jquery/**", "/css/**", "/js/**", "/images/**", "/fonts/**", "/**/favicon.ico", "/**");
    }
}
