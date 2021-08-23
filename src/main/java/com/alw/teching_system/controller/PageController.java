package com.alw.teching_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 配置页面请求的映射
 */
@Controller
public class PageController {

    @GetMapping({"/main.html","/"})
    public String mainPage(){
        return "main";
    }

    @GetMapping("/login.html")
    public String loginPage(){
        return "login";
    }

}
