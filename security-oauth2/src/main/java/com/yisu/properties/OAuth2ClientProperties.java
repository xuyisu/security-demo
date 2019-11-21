package com.yisu.properties;

import lombok.Data;

/**
 *
 * @author xuyisu
 */
@Data
public class OAuth2ClientProperties {

    private String clientId;

    private String clientSecret;

    private Integer accessTokenValiditySeconds = 7200;
}
