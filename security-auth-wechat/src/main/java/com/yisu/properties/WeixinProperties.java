/**
 *
 */
package com.yisu.properties;

import com.yisu.social.weixin.config.SocialProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xuyisu
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WeixinProperties extends SocialProperties {

	/**
	 * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
	 */
	private String providerId = "weixin";



}
