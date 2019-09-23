package com.example.bootMp.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@TableName("t_comment")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 评论者IP
     */
    private String userIp;
    /**
     * 被评论博客的主键
     */
    private Integer blogId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论时间
     */
    private Date commentDate;
    /**
     * 评论状态：0未审核1审核通过2审核不通过
     */
    private Integer state;


    public Integer getId() {
        return id;
    }

    public Comment setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserIp() {
        return userIp;
    }

    public Comment setUserIp(String userIp) {
        this.userIp = userIp;
        return this;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public Comment setBlogId(Integer blogId) {
        this.blogId = blogId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public Comment setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public Comment setState(Integer state) {
        this.state = state;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Comment{" +
        ", id=" + id +
        ", userIp=" + userIp +
        ", blogId=" + blogId +
        ", content=" + content +
        ", commentDate=" + commentDate +
        ", state=" + state +
        "}";
    }
}
