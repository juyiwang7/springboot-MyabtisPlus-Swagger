package com.example.bootMp.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.bootMp.entity.Blog;
import com.example.bootMp.service.IBlogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 博客表 前端控制器
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;


    @ApiOperation(value = "查找所有的博客",notes = "获取博客列表")
    @RequestMapping(value = "bloglist",method = RequestMethod.POST)
    private List<Blog> bloglist(){
        List<Blog> blogList = blogService.selectList(new EntityWrapper<Blog>());
        return blogList;

    }

}
