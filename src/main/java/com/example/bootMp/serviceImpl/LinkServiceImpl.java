package com.example.bootMp.serviceImpl;

import com.example.bootMp.entity.Link;
import com.example.bootMp.mapper.LinkMapper;
import com.example.bootMp.service.ILinkService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 友情链接 服务实现类
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements ILinkService {

}
