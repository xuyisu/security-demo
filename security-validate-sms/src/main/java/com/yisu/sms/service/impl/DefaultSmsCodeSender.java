/**
 *
 */
package com.yisu.sms.service.impl;

import com.yisu.sms.service.SmsCodeSender;

/**
 * @author xuyisu
 *
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机"+mobile+"发送短信验证码"+code);
	}

}
