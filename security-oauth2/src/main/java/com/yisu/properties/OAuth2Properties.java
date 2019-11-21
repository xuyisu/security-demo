package com.yisu.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xuyisu
 */
@Data
public class OAuth2Properties {

    private String jwtSigningKey = "fw";

    private OAuth2ClientProperties[] clients = {};
}
