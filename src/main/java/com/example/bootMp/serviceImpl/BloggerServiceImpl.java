package com.example.bootMp.serviceImpl;

import com.example.bootMp.entity.Blogger;
import com.example.bootMp.mapper.BloggerMapper;
import com.example.bootMp.service.IBloggerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博主 服务实现类
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@Service
public class BloggerServiceImpl extends ServiceImpl<BloggerMapper, Blogger> implements IBloggerService {

}
