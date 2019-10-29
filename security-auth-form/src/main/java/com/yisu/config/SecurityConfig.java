package com.yisu.config;

import com.yisu.authentication.FwAuthenctiationFailureHandler;
import com.yisu.authentication.FwAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName SecurityConfig
 * @Author xuyisu
 * @Description
 * @Date 2019/10/29
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FwAuthenticationSuccessHandler fwAuthenticationSuccessHandler;

    @Autowired
    private FwAuthenctiationFailureHandler fwAuthenctiationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/default-login.html")
                .successHandler(fwAuthenticationSuccessHandler)
                .failureHandler(fwAuthenctiationFailureHandler)
                .and()
                .csrf().disable();
    }
}
