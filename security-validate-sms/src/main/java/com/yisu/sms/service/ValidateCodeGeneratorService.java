/**
 *
 */
package com.yisu.sms.service;

import com.yisu.sms.image.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author xuyisu
 *
 */
public interface ValidateCodeGeneratorService {

	ValidateCode generate(ServletWebRequest request);

}
