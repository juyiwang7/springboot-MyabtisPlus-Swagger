package com.example.bootMp.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author weisan
 * @since 2020-04-17
 */
public class User_role extends Model<User_role> {

    private static final long serialVersionUID = 1L;

    private Integer user_id;
    private String role_key;


    public Integer getUser_id() {
        return user_id;
    }

    public User_role setUser_id(Integer user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getRole_key() {
        return role_key;
    }

    public User_role setRole_key(String role_key) {
        this.role_key = role_key;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.user_id;
    }

    @Override
    public String toString() {
        return "User_role{" +
        ", user_id=" + user_id +
        ", role_key=" + role_key +
        "}";
    }
}
