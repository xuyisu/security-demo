package com.yisu.server.properties;

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

    private Integer refreshTokenValiditySecond = 60 * 60 * 24 * 15;

    private String redirectUri;

    private String scope = "all";

    private Boolean autoApprove;
}
