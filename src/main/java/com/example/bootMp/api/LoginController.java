package com.example.bootMp.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.example.bootMp.common.base.BaseResult;
import com.example.bootMp.entity.User;
import com.example.bootMp.service.IUserService;
import com.example.bootMp.utils.PasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
public class LoginController {
    @Autowired
    private IUserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private HttpServletResponse response;

    @RequestMapping("/login")
    public String login(String username, String password, Model model){

        if (username==null || username.equals("")){
            model.addAttribute("msg",BaseResult.error("500","用户名错误"));
            return "index";
        }
        if (password==null || password.equals("")){
            model.addAttribute("msg",BaseResult.error("500","密码错误"));
            return "index";
        }
        Map<String, Object> usermsg = loginService.login(username, password, response);
        model.addAttribute("message", BaseResult.ok("msg",usermsg));
        return "home";

    }
}
