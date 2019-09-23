package com.example.bootMp.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 友情链接
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@TableName("t_link")
public class Link extends Model<Link> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 网站名称
     */
    private String linkName;
    /**
     * 网站地址
     */
    private String linkUrl;
    /**
     * 序号
     */
    private Integer orderNo;


    public Integer getId() {
        return id;
    }

    public Link setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLinkName() {
        return linkName;
    }

    public Link setLinkName(String linkName) {
        this.linkName = linkName;
        return this;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public Link setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
        return this;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public Link setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Link{" +
        ", id=" + id +
        ", linkName=" + linkName +
        ", linkUrl=" + linkUrl +
        ", orderNo=" + orderNo +
        "}";
    }
}
