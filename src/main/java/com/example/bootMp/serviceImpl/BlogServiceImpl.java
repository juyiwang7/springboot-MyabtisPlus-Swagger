package com.example.bootMp.serviceImpl;

import com.example.bootMp.entity.Blog;
import com.example.bootMp.mapper.BlogMapper;
import com.example.bootMp.service.IBlogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 博客表 服务实现类
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@Service
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private BlogMapper blogMapper;



    @Transactional
    @Override
    public void save() {
        Blog blog = new Blog();
        blog.setTitle("测试注解事务的使用");
        blogService.insert(blog);
        if (true) {
            throw new RuntimeException("save 抛异常了");
        }
    }

    @Override
    public Blog mySelectById(String id) {
        return blogMapper.mySelectById(id);
    }
}
