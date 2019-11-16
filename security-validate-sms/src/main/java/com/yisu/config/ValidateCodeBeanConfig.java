/**
 *
 */
package com.yisu.config;

import com.yisu.sms.service.SmsCodeSenderService;
import com.yisu.sms.service.impl.DefaultSmsCodeSenderImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuyisu
 *
 */
@Configuration
public class ValidateCodeBeanConfig {


	@Bean
	@ConditionalOnMissingBean(SmsCodeSenderService.class)
	public SmsCodeSenderService smsCodeSender() {
		return new DefaultSmsCodeSenderImpl();
	}


}
