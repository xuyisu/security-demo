package com.yisu.oauth2.db.controller;

import com.yisu.result.FwResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("users")
public class HelloController {


    /**
     * 获取用户信息
     *
     * @return
     */
    @RequestMapping("/user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public FwResult getUser() {
        List<Map<String, String>> maps = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("username", "李四");
        map.put("sex", "男");
        maps.add(map);
        return FwResult.ok(maps);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @RequestMapping("/error")
    @PreAuthorize("hasAuthority('ADMIN333')")
    public FwResult error() {
        return FwResult.failed();
    }


}
