package com.yisu.oauth2.db.service;

import com.yisu.oauth2.db.entity.SysUser;

/**
 * 用户操作相关
 * @date 2019/10/11
 * @author xuyisu
 */
public interface FwUserService {

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    SysUser getUserByUserName(String userName);

    /**
     * 根据用户名获取用户权限
     * @param userName
     * @return
     */
    String getPowersByUserName(String userName);
}
