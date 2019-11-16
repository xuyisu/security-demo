/**
 *
 */
package com.yisu.sms.utils;

import com.yisu.enums.ValidateCodeType;
import com.yisu.sms.exception.ValidateCodeException;
import com.yisu.sms.service.ValidateCodeProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @author xuyisu
 *
 */
@Component
public class ValidateCodeProcessorHolder {

	@Autowired
	private Map<String, ValidateCodeProcessorService> validateCodeProcessors;

	public ValidateCodeProcessorService findValidateCodeProcessor(ValidateCodeType type) {
		return findValidateCodeProcessor(type.toString().toLowerCase());
	}

	public ValidateCodeProcessorService findValidateCodeProcessor(String type) {
		String name = type.toLowerCase() + ValidateCodeProcessorService.class.getSimpleName();
		ValidateCodeProcessorService processor = validateCodeProcessors.get(name);
		if (processor == null) {
			throw new ValidateCodeException("验证码处理器" + name + "不存在");
		}
		return processor;
	}

}
