package com.example.bootMp.mapper;

import com.example.bootMp.entity.Blog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 博客表 Mapper 接口
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

}
