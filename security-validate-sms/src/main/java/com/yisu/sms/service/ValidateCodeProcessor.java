/**
 *
 */
package com.yisu.sms.service;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码处理器，封装不同校验码的处理逻辑
 *
 * @author xuyisu
 *
 */
public interface ValidateCodeProcessor {

	/**
	 * 验证码放入session时的前缀
	 */
	String SESSION_KEY_PREFIX = "SESSION_KEY_IMAGE_CODE";

	/**
	 * 创建校验码
	 *
	 * @param request
	 * @throws Exception
	 */
	void create(ServletWebRequest request) throws Exception;

	/**
	 * 校验验证码
	 *
	 * @param servletWebRequest
	 * @throws Exception
	 */
	void validate(ServletWebRequest servletWebRequest);

}
