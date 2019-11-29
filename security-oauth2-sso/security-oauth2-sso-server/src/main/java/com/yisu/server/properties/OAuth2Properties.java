package com.yisu.server.properties;

import lombok.Data;

/**
 * @author xuyisu
 */
@Data
public class OAuth2Properties {

    private String jwtSigningKey = "fw";

    private OAuth2ClientProperties[] clients = {};
}
