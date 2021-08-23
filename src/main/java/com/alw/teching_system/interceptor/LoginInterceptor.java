package com.alw.teching_system.interceptor;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if("UID".equals(cookie.getName())){
                    if (!ObjectUtils.isEmpty(session.getAttribute(cookie.getValue()))){
                        response.sendRedirect("/main.html");
                        return true;
                    }
                }
            }
        }
        response.sendRedirect("/login.html");
        return true;

    }


}
