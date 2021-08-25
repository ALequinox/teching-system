package com.alw.teching_system.controller;

import com.alw.teching_system.entity.Message;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 配置页面请求的映射
 */
@Controller
public class PageController {

    /**
     * 跳转到初始页面
     * 在这里面向请求域放入一些数据
     */
    @GetMapping({"/main.html","/","/index"})
    public String mainPage(HttpServletRequest request,
                           HttpSession session){
        //获得登录的用户信息
        Authentication authentication = SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication();
        System.out.println(authentication);
        Object o = session.getAttribute("message");
        if(ObjectUtils.isEmpty(o)){
            request.setAttribute("message", new Message());
        }else{
            request.setAttribute("message", o);
            session.removeAttribute("message");
        }
        return "main";
    }

    /**
     * 跳转到登录页
     * 在这里面向请求域中放入一些数据
     */
    @GetMapping("/login.html")
    public String loginPage(HttpServletRequest request){
        //放入一个空的message
        request.setAttribute("message",new Message());
        return "login";
    }

}
