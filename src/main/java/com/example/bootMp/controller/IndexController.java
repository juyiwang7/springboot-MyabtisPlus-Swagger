package com.example.bootMp.controller;

import com.example.bootMp.annotation.AopTest;
import com.example.bootMp.annotation.Auth;
import com.example.bootMp.entity.User;
import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
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



    public static void main(String[] args) {
        //加载测试文档
        PdfDocument pdf = new PdfDocument("D:\\ToWord.pdf");
        //保存为Word,带图片
        pdf.saveToFile("ToWord.docx", FileFormat.DOCX);
        //保存为HTML格式
        //pdf.saveToFile("ToHTML.html", FileFormat.HTML);
        //保存为SVG格式
        //pdf.saveToFile("ToSVG.svg", FileFormat.SVG);
        //保存为XPS格式
        //pdf.saveToFile("ToXPS.xps", FileFormat.XPS);
    }

}
