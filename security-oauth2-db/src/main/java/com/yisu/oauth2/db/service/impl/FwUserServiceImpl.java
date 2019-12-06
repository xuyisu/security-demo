package com.yisu.oauth2.db.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yisu.oauth2.db.constant.FwAuthConstant;
import com.yisu.oauth2.db.entity.SysUser;
import com.yisu.oauth2.db.mapper.SysUserMapper;
import com.yisu.oauth2.db.service.FwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class FwUserServiceImpl implements FwUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserByUserName(String username) {
        SysUser sysUser=new SysUser();
        sysUser.setUserName(username);
        sysUser.setDisableFlag(FwAuthConstant.STATUS_ENABLE);
        return sysUserMapper.selectOne(Wrappers.query(sysUser));
    }

    @Override
    public String getPowersByUserName(String userName) {
        List<String> powers = sysUserMapper.getPowersByUserName(userName);
        if(!CollectionUtils.isEmpty(powers)){
            return powers.stream().collect(Collectors.joining(","));
        }
        return "";
    }
}
