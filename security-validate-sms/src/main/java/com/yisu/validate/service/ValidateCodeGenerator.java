/**
 *
 */
package com.yisu.validate.service;

import com.yisu.validate.image.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author xuyisu
 *
 */
public interface ValidateCodeGenerator {
	/**
	 * 生成验证码
	 * @param request
	 * @return
	 */
	ValidateCode generate(ServletWebRequest request);

}
