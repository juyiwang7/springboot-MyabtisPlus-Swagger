package com.example.bootMp.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author weisan
 * @since 2020-04-17
 */
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    private String rkey;
    private String name;
    private String description;


    public String getRkey() {
        return rkey;
    }

    public Role setRkey(String rkey) {
        this.rkey = rkey;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Role setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.rkey;
    }

    @Override
    public String toString() {
        return "Role{" +
        ", rkey=" + rkey +
        ", name=" + name +
        ", description=" + description +
        "}";
    }
}
