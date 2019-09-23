package com.example.bootMp.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 博主
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@TableName("t_blogger")
public class Blogger extends Model<Blogger> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 登录名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 个人信息
     */
    private String profile;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 个性签名
     */
    private String sign;
    /**
     * 头像地址
     */
    private String imageName;


    public Integer getId() {
        return id;
    }

    public Blogger setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Blogger setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Blogger setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getProfile() {
        return profile;
    }

    public Blogger setProfile(String profile) {
        this.profile = profile;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public Blogger setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public Blogger setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getImageName() {
        return imageName;
    }

    public Blogger setImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Blogger{" +
        ", id=" + id +
        ", userName=" + userName +
        ", password=" + password +
        ", profile=" + profile +
        ", nickName=" + nickName +
        ", sign=" + sign +
        ", imageName=" + imageName +
        "}";
    }
}
