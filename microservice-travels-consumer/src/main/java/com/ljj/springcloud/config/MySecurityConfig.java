package com.ljj.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .and()
                //登录页
                // GET类型的请求/login的话，跳转到spring security默认登录页
                // POST类型的请求/login的话，就是登录的动作,后面要写到form action
                // /login?error 认证失败后，重定向
                // 如果直接写的是formLogin() 跳转的是默认页
                // 修改为/userlogin的话，那么自定义登录页的th:action="userlogin" method="post"
                //1.  formLogin().loginPage("/userlogin")
                //2.  index.html  a th:href="@{/userlogin}" GET
                //3.  login.html  form th:action="@{/userlogin}" method="POST"
                //4.  IndexAction.java GetMapping("/userlogin")
                .formLogin().usernameParameter("passport").passwordParameter("password").loginPage("/userlogin")
                .and()
                //登出页面需要post请求，因此
                .logout().logoutSuccessUrl("/")
                .and()
                .rememberMe().rememberMeParameter("rememberMe");
    }

}
