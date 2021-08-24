package com.alw.teching_system.controller;

import com.alw.teching_system.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
    /**
     * 验证失败，转发到这里，对错误信息进行包装
     */
    @PostMapping("login-fail")
    public String loginFail(HttpServletRequest request){
        //Exception exception = (Exception) request.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        Message message = new Message();
        message.setCode(403);
        message.setMessage("用户名或密码错误");
        request.setAttribute("message",message);
        return "login";
    }
}
