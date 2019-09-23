package com.example.bootMp.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 博客表
 * </p>
 *
 * @author lqh
 * @since 2019-09-23
 */
@TableName("t_blog")
public class Blog extends Model<Blog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 发表时间
     */
    private Date releaseDate;
    /**
     * 点击数
     */
    private Integer clickHit;
    /**
     * 评论数
     */
    private Integer replyHit;
    /**
     * 内容
     */
    private String content;
    /**
     * 所属博客类型
     */
    private Integer typeId;
    /**
     * 关键字
     */
    private String keyWord;


    public Integer getId() {
        return id;
    }

    public Blog setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Blog setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Blog setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Blog setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public Blog setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
        return this;
    }

    public Integer getReplyHit() {
        return replyHit;
    }

    public Blog setReplyHit(Integer replyHit) {
        this.replyHit = replyHit;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Blog setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public Blog setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public Blog setKeyWord(String keyWord) {
        this.keyWord = keyWord;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Blog{" +
        ", id=" + id +
        ", title=" + title +
        ", summary=" + summary +
        ", releaseDate=" + releaseDate +
        ", clickHit=" + clickHit +
        ", replyHit=" + replyHit +
        ", content=" + content +
        ", typeId=" + typeId +
        ", keyWord=" + keyWord +
        "}";
    }
}
