package com.alw.teching_system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    /**
     * 将密码编码解码的bean注册入容器中
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * 配置security
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    .formLogin()
                .loginPage("/login.html") //设置登录页
                .loginProcessingUrl("/login") //设置登录的url
                .defaultSuccessUrl("/") //成功后默认跳转的路径
                .failureForwardUrl("/login-fail")//失败后请求转发url
                .permitAll(); //登录失败后跳转的url

        http    .authorizeRequests()
                .antMatchers("/static/**","/login.html")
                .permitAll() //指定url无需保护
                .anyRequest()//其他请求
                .authenticated(); //需要认证

        http.csrf().disable(); //关闭csrf

    }
}
