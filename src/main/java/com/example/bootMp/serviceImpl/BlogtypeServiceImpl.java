package com.example.bootMp.serviceImpl;

import com.example.bootMp.entity.Blogtype;
import com.example.bootMp.mapper.BlogtypeMapper;
import com.example.bootMp.service.IBlogtypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客类型表 服务实现类
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@Service
public class BlogtypeServiceImpl extends ServiceImpl<BlogtypeMapper, Blogtype> implements IBlogtypeService {

}
