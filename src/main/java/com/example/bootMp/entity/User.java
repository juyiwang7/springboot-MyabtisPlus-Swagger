package com.example.bootMp.entity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.example.bootMp.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * 系统用户
 *
 * @author wwyz
 * @since 2019-10-04
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
@ApiModel(value = "User对象", description = "系统用户")
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("email")
    private String email;

    @TableField("mobile")
    private String mobile;

    @TableField("status")
    private Boolean status;

    @TableField("user_type")
    private String userType;

    @TableField("realname")
    private String realname;

    @TableField("sex")
    private String sex;

    public static class Fields extends BaseEntity.Fields {
        public static final String username = "username";
        public static final String password = "password";
        public static final String email = "email";
        public static final String mobile = "mobile";
        public static final String status = "status";
        public static final String userType = "user_type";
        public static final String realname = "realname";
        public static final String sex = "sex";
    }
}
