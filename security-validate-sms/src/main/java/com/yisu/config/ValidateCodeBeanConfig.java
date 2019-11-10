/**
 *
 */
package com.yisu.config;

import com.yisu.properties.SecurityProperties;
import com.yisu.sms.service.SmsCodeSender;
import com.yisu.sms.service.impl.DefaultSmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
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
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
	}


}
