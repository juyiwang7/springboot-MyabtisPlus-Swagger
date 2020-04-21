package com.example.bootMp.serviceImpl;

import com.example.bootMp.entity.Role;
import com.example.bootMp.mapper.RoleMapper;
import com.example.bootMp.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author weisan
 * @since 2020-04-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> GetAllRoles(Role role) {
        return roleMapper.GetAllRoles(role);
    }


}
