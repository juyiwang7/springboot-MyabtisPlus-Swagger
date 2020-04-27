package com.example.bootMp.serviceImpl;

import com.example.bootMp.entity.User;
import com.example.bootMp.mapper.UserMapper;
import com.example.bootMp.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author weisan
 * @since 2020-04-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getAvailableUserByName(String username, boolean b) {
        User user = new User();
        user.setUsername(username);
        User user1 = userMapper.selectOne(user);
        return user1;
    }
}
