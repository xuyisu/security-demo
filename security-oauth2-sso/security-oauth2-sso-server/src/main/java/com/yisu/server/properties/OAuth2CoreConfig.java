package com.yisu.server.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author xuyisu
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class OAuth2CoreConfig {
}
