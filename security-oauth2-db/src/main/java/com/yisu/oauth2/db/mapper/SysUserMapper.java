package com.yisu.oauth2.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yisu.oauth2.db.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统用户表-Mapper
 * @author xuyisu
 * @date '2019-10-17 19:25:49'.
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据用户名获取权限
     * @param userName
     * @return
     */
    List<String> getPowersByUserName(@Param("userName") String userName);
}
