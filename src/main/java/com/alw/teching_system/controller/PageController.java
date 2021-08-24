package com.alw.teching_system.controller;

import com.alw.teching_system.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 配置页面请求的映射
 */
@Controller
public class PageController {

    @GetMapping({"/main.html","/","/index"})
    public String mainPage(){
        return "main";
    }

    @GetMapping("/login.html")
    public String loginPage(HttpServletRequest request){
        //放入一个空的message
        request.setAttribute("message",new Message());
        return "login";
    }

}
