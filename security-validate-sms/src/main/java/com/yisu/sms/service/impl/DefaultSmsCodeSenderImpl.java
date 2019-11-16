/**
 *
 */
package com.yisu.sms.service.impl;

import com.yisu.sms.service.SmsCodeSenderService;

/**
 * @author xuyisu
 *
 */
public class DefaultSmsCodeSenderImpl implements SmsCodeSenderService {

	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机"+mobile+"发送短信验证码"+code);
	}

}
