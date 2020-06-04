package com.example.bootMp.controller;

import com.example.bootMp.annotation.AopTest;
import com.example.bootMp.annotation.Auth;
import com.example.bootMp.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","后台返回消息");
        return "index";
    }

    @AopTest("参数JDG")
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("msg","转向login页面");
        return "Login";
    }

    @Auth
    @RequestMapping("/testAuth")
    public String testAuth(User user,Model model){
        model.addAttribute("message",user.getUsername()+":已通过认证！");
        return "home";
    }
}
