package com.example.dubboclient.config.security;

import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.api.entity.Constants;
import com.example.api.utils.StringHelper;

/**
 * spring-boot-security
 * 
 * @author Administrator
 *
 */
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
    
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // 定义哪些URL需要被保护, 哪些不需要被保护
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .antMatchers("/", "/index.html").permitAll()
                .anyRequest().authenticated() // 任何请求, 登录后可以访问
                .and().formLogin() // 定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login").failureUrl("/login?error=true").permitAll() // 登录页面用户任意访问
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll() // 注销行为任意访问
                .and().rememberMe().key(Constants.contextPath) // 启用 remember me
                .and().exceptionHandling().accessDeniedPage("/403");  // 处理异常，拒绝访问就重定向到 403 页面
//        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
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
                return encodedPassword.equals(StringHelper.MD5encode(rawPassword.toString()));
            }
        });
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**/*.js", "/**/*.css", "/**/*.woff", "/**/*.woff2", "/common/assets/imgs/*", "/favicon.ico");
    }
}
