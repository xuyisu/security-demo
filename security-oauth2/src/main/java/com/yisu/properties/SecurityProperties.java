package com.yisu.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author xuyisu
 * @Date 2019/10/29
 * @Param
 * @Return
 */
@ConfigurationProperties(prefix = "fw.security")
@Data
public class SecurityProperties {

    private OAuth2Properties oauth = new OAuth2Properties();
}

