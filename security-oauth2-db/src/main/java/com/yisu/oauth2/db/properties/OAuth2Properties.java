package com.yisu.oauth2.db.properties;

import lombok.Data;

/**
 * @author xuyisu
 */
@Data
public class OAuth2Properties {

    /**
     * 签名
     */
    private String jwtSigningKey = "fw";

    /**
     * redis 存储token信息前缀
     */
    private String redisTokenPrefix ="fw:auth:";



    private OAuth2ClientProperties[] clients = {};
}
