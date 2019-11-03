package com.yisu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author xuyisu
 * @Description
 * @Date 2019/10/16
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "helo security";
    }


}
