package com.example.bootMp.service;

import com.example.bootMp.entity.Blog;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 博客表 服务类
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
public interface IBlogService extends IService<Blog> {
    void save();

    Blog mySelectById(String id);


}
