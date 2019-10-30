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

	ValidateCode generate(ServletWebRequest request);

}
