package com.yisu.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(101)
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
}