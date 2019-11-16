package com.yisu.controller;

import com.yisu.sms.utils.ValidateCodeProcessorHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class SMSCodeController {

    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    @GetMapping("/code/sms")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        validateCodeProcessorHolder.findValidateCodeProcessor("sms").create(new ServletWebRequest(request, response));
    }
}
