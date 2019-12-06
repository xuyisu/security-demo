package com.yisu.oauth2.db.service;

import cn.hutool.core.util.StrUtil;
import com.yisu.oauth2.db.constant.FwAuthConstant;
import com.yisu.oauth2.db.entity.FwAuthUser;
import com.yisu.oauth2.db.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
@Slf4j
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private FwUserService fwUserService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("username: " + username);
        /**
         * 查询用户
         */
        SysUser sysUser = fwUserService.getUserByUserName(username);
        if (sysUser != null) {
            /**
             * 查询用户相关权限
             */
            String permissions = fwUserService.getPowersByUserName(username);
            FwAuthUser authUser = new FwAuthUser(sysUser.getId(),sysUser.getDeptCode(),sysUser.getUserName(), FwAuthConstant.BCRYPT + sysUser.getPassword(),
                    sysUser.getDisableFlag()== FwAuthConstant.STATUS_ENABLE, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
            return authUser;
        } else {
            log.error("用户{}不存在",username);
            throw new UsernameNotFoundException("用户不存在");
        }
    }

}
