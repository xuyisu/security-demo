/**
 *
 */
package com.yisu.sms.service.impl;

import com.yisu.constants.FwCommonConstants;
import com.yisu.sms.image.ValidateCode;
import com.yisu.sms.service.SmsCodeSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码处理器
 *
 * @author xuyisu
 *
 */
@Component("smsValidateCodeProcessorService")
public class SmsCodeProcessorImpl extends AbstractValidateCodeProcessorImpl<ValidateCode> {

	/**
	 * 短信验证码发送器
	 */
	@Autowired
	private SmsCodeSenderService smsCodeSender;

	@Override
	protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
		String paramName = FwCommonConstants.DEFAULT_PARAMETER_NAME_MOBILE;
		String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
		smsCodeSender.send(mobile, validateCode.getCode());
	}

}
