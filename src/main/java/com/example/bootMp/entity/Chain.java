package com.example.bootMp.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * chain表
 * </p>
 *
 * @author weisan
 * @since 2020-04-17
 */
public class Chain extends Model<Chain> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String user_account;
    private String description;
    private String consensus;
    private String peers_orgs;
    private Integer order_count;
    private Integer peer_count;
    private String tls_enabled;
    private Integer status;
    private Long created;


    public Integer getId() {
        return id;
    }

    public Chain setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Chain setName(String name) {
        this.name = name;
        return this;
    }

    public String getUser_account() {
        return user_account;
    }

    public Chain setUser_account(String user_account) {
        this.user_account = user_account;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Chain setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getConsensus() {
        return consensus;
    }

    public Chain setConsensus(String consensus) {
        this.consensus = consensus;
        return this;
    }

    public String getPeers_orgs() {
        return peers_orgs;
    }

    public Chain setPeers_orgs(String peers_orgs) {
        this.peers_orgs = peers_orgs;
        return this;
    }

    public Integer getOrder_count() {
        return order_count;
    }

    public Chain setOrder_count(Integer order_count) {
        this.order_count = order_count;
        return this;
    }

    public Integer getPeer_count() {
        return peer_count;
    }

    public Chain setPeer_count(Integer peer_count) {
        this.peer_count = peer_count;
        return this;
    }

    public String getTls_enabled() {
        return tls_enabled;
    }

    public Chain setTls_enabled(String tls_enabled) {
        this.tls_enabled = tls_enabled;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Chain setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Long getCreated() {
        return created;
    }

    public Chain setCreated(Long created) {
        this.created = created;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Chain{" +
        ", id=" + id +
        ", name=" + name +
        ", user_account=" + user_account +
        ", description=" + description +
        ", consensus=" + consensus +
        ", peers_orgs=" + peers_orgs +
        ", order_count=" + order_count +
        ", peer_count=" + peer_count +
        ", tls_enabled=" + tls_enabled +
        ", status=" + status +
        ", created=" + created +
        "}";
    }
}
