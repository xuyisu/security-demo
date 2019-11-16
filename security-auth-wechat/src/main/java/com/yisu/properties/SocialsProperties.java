/**
 *
 */
package com.yisu.properties;

import lombok.Data;

/**
 * @author zhailiang
 *
 */
@Data
public class SocialsProperties {

	private String filterProcessesUrl = "/auth";


	private WeixinProperties weixin = new WeixinProperties();



}
