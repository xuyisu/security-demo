/**
 *
 */
package com.yisu.properties;


import com.yisu.social.qq.config.SocialProperties;

/**
 * @author xuyisu
 *
 */
public class QQProperties extends SocialProperties {

	private String providerId = "qq";

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

}
