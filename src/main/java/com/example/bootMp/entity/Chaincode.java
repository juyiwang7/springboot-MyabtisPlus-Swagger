package com.example.bootMp.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * chaincode表
 * </p>
 *
 * @author weisan
 * @since 2020-04-17
 */
public class Chaincode extends Model<Chaincode> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String chaincode_name;
    private Integer channel_id;
    private String user_account;
    private Long created;
    private String version;
    private Integer status;
    private String github_path;
    private String args;
    private String policy;


    public Integer getId() {
        return id;
    }

    public Chaincode setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getChaincode_name() {
        return chaincode_name;
    }

    public Chaincode setChaincode_name(String chaincode_name) {
        this.chaincode_name = chaincode_name;
        return this;
    }

    public Integer getChannel_id() {
        return channel_id;
    }

    public Chaincode setChannel_id(Integer channel_id) {
        this.channel_id = channel_id;
        return this;
    }

    public String getUser_account() {
        return user_account;
    }

    public Chaincode setUser_account(String user_account) {
        this.user_account = user_account;
        return this;
    }

    public Long getCreated() {
        return created;
    }

    public Chaincode setCreated(Long created) {
        this.created = created;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public Chaincode setVersion(String version) {
        this.version = version;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Chaincode setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getGithub_path() {
        return github_path;
    }

    public Chaincode setGithub_path(String github_path) {
        this.github_path = github_path;
        return this;
    }

    public String getArgs() {
        return args;
    }

    public Chaincode setArgs(String args) {
        this.args = args;
        return this;
    }

    public String getPolicy() {
        return policy;
    }

    public Chaincode setPolicy(String policy) {
        this.policy = policy;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Chaincode{" +
        ", id=" + id +
        ", chaincode_name=" + chaincode_name +
        ", channel_id=" + channel_id +
        ", user_account=" + user_account +
        ", created=" + created +
        ", version=" + version +
        ", status=" + status +
        ", github_path=" + github_path +
        ", args=" + args +
        ", policy=" + policy +
        "}";
    }
}
