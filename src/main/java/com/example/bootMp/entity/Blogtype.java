package com.example.bootMp.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 博客类型表
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@TableName("t_blogtype")
public class Blogtype extends Model<Blogtype> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "blogtypeid", type = IdType.AUTO)
    private Integer blogtypeid;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 序号
     */
    private Integer orderNo;


    public Integer getBlogtypeid() {
        return blogtypeid;
    }

    public Blogtype setBlogtypeid(Integer blogtypeid) {
        this.blogtypeid = blogtypeid;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public Blogtype setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public Blogtype setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.blogtypeid;
    }

    @Override
    public String toString() {
        return "Blogtype{" +
        ", blogtypeid=" + blogtypeid +
        ", typeName=" + typeName +
        ", orderNo=" + orderNo +
        "}";
    }
}
