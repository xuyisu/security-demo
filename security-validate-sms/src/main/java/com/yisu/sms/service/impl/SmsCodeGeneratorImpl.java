/**
 *
 */
package com.yisu.sms.service.impl;

import com.yisu.properties.SecurityProperties;
import com.yisu.sms.image.ValidateCode;
import com.yisu.sms.service.ValidateCodeGeneratorService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author xuyisu
 *
 */
@Component("smsValidateCodeGeneratorService")
public class SmsCodeGeneratorImpl implements ValidateCodeGeneratorService {

	@Autowired
	private SecurityProperties securityProperties;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.imooc.security.core.validate.code.ValidateCodeGeneratorService#generate(org.
	 * springframework.web.context.request.ServletWebRequest)
	 */
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
		return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
	}

	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}



}
