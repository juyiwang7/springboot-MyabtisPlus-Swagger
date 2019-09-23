package com.example.bootMp.serviceImpl;

import com.example.bootMp.entity.Comment;
import com.example.bootMp.mapper.CommentMapper;
import com.example.bootMp.service.ICommentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
