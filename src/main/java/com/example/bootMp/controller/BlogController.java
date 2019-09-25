package com.example.bootMp.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.bootMp.entity.Blog;
import com.example.bootMp.entity.Blogger;
import com.example.bootMp.mapper.BlogMapper;
import com.example.bootMp.service.IBlogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    @Resource
    private IBlogService blogService;


    @ApiOperation(value = "查找所有的博客",notes = "获取博客列表")
    @RequestMapping(value = "/bloglist",method = RequestMethod.GET)
    private List<Blog> bloglist(){
        List<Blog> blogList = blogService.selectList(new EntityWrapper<Blog>());
        //blogService.save();
        return blogList;
    }

    /**
     * 测试自定义SQL语句
     * 1.首先在Mapper中使用注解写好SQL语句，这时候的Mapper就相当于Dao层（也可以用Mapper.xml的注解形式完成SQL语句）
     * 2.然后在对应的service中写一样的方法
     * 3.在serviceImpl中，具体写这个方法，主要是调用Mapper的方法。
     * 4.Mapper一般不能自动注入，所以需要在Mapper上加上@Component，使其可以自动注入
     * @return
     */
    @ApiOperation(value = "MyMySQL",notes = "测试自定义SQL语句")
    @RequestMapping(value = "/MyMySQL",method = RequestMethod.GET)
    private Blog MyMySQL(){
        Blog blog = blogService.mySelectById("83");
        return blog;
    }




}

