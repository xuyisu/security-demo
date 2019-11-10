/**
 *
 */
package com.yisu.sms.properties;

import lombok.Data;

/**
 * @author xuyisu
 *
 */
@Data
public class SmsCodeProperties {

	private int length = 6;
	private int expireIn = 60;

	private String url;


}
