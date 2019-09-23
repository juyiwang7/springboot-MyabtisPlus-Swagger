package com.example.bootMp.serviceImpl;

import com.example.bootMp.entity.Blog;
import com.example.bootMp.mapper.BlogMapper;
import com.example.bootMp.service.IBlogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客表 服务实现类
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
