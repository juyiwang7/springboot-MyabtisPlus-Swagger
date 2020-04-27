package com.example.bootMp.service;

import com.example.bootMp.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author weisan
 * @since 2020-04-17
 */
public interface IUserService extends IService<User> {

    User getAvailableUserByName(String username, boolean b);
}
