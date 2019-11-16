/**
 *
 */
package com.yisu.sms.service;

/**
 * @author xuyisu
 *
 */
public interface SmsCodeSenderService {

	void send(String mobile, String code);

}
