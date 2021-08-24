package com.alw.teching_system.config;

import com.alw.teching_system.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //添加登录拦截器，使用cookie和session保证登录
//        List<String> paths = new ArrayList<>();
//        paths.add("/static/**");
//        paths.add("/login*");
//        paths.add("/error");
//        registry.addInterceptor(new LoginInterceptor())
//                .excludePathPatterns(paths)
//                .addPathPatterns("/**");
//    }
}
