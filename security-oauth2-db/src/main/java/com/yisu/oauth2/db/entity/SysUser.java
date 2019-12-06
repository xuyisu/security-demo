package com.yisu.oauth2.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 系统用户表-实体
 * @author xuyisu
 * @date '2019-10-17 19:25:49'.
 */
@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = false)
public class SysUser extends BaseModel {

    /**
     * 职位编码
     */
    private String posCode;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 部门编码
     */
    private String deptCode;
    /**
     * 手机号
     */
    private String userPhone;
}
