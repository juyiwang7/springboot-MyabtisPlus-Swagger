package com.example.bootMp.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * channel表
 * </p>
 *
 * @author weisan
 * @since 2020-04-17
 */
public class Channel extends Model<Channel> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer chain_id;
    private String orgs;
    private String channel_name;
    private String user_account;
    private Long created;


    public Integer getId() {
        return id;
    }

    public Channel setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getChain_id() {
        return chain_id;
    }

    public Channel setChain_id(Integer chain_id) {
        this.chain_id = chain_id;
        return this;
    }

    public String getOrgs() {
        return orgs;
    }

    public Channel setOrgs(String orgs) {
        this.orgs = orgs;
        return this;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public Channel setChannel_name(String channel_name) {
        this.channel_name = channel_name;
        return this;
    }

    public String getUser_account() {
        return user_account;
    }

    public Channel setUser_account(String user_account) {
        this.user_account = user_account;
        return this;
    }

    public Long getCreated() {
        return created;
    }

    public Channel setCreated(Long created) {
        this.created = created;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Channel{" +
        ", id=" + id +
        ", chain_id=" + chain_id +
        ", orgs=" + orgs +
        ", channel_name=" + channel_name +
        ", user_account=" + user_account +
        ", created=" + created +
        "}";
    }
}
