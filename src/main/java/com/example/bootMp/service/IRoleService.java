package com.example.bootMp.service;

import com.example.bootMp.entity.Role;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author weisan
 * @since 2020-04-17
 */
public interface IRoleService extends IService<Role> {
    List<Role>GetAllRoles(Role role);

}
