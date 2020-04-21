package com.example.bootMp.mapper;

import com.example.bootMp.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author weisan
 * @since 2020-04-17
 */
public interface RoleMapper extends BaseMapper<Role> {
    @Select("SELECT * FROM role")
    List<Role> GetAllRoles(Role role);

}
