package com.yisu.form.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author xuyisu
 * @Description
 * @Date 2019/10/16
 */
@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("/hello")
    public String index() {
        return "helo user";
    }

}
