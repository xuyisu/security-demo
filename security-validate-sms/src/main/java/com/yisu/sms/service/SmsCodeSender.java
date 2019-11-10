/**
 *
 */
package com.yisu.sms.service;

/**
 * @author xuyisu
 *
 */
public interface SmsCodeSender {

	void send(String mobile, String code);

}
