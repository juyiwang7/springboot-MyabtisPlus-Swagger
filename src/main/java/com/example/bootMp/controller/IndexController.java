package com.example.bootMp.controller;

import com.example.bootMp.annotation.AopTest;
import com.example.bootMp.annotation.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","后台返回消息");
        return "index";
    }

    @Auth
    @AopTest("参数JDG")
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("msg","转向login页面");
        return "Login";
    }
}
