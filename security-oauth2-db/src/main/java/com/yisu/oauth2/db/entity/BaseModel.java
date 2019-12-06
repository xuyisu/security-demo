package com.yisu.oauth2.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName BaseModel
 * @Author xuyisu
 * @Description 基础实体类
 * @Date 2019/10/17
 */
@Data
public class BaseModel {

    private static final long serialVersionUID = 42L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建人编码
     */
    private String createUser;
    /**
     * 修改人编码
     */
    private String updateUser;
    /**
     * 删除标记(1 删除 0未删除)
     */
    @TableLogic
    private Integer deleteFlag;
    /**
     * 启用标记(1 禁用 0启用)
     */
    private Integer disableFlag;
}
