package com.example.bootMp.mapper;

import com.example.bootMp.entity.Blog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 博客表 Mapper 接口
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@Component
public interface BlogMapper extends BaseMapper<Blog> {
    @Select("SELECT * FROM t_blog WHERE id = #{0}")
    Blog mySelectById(String id);
}
