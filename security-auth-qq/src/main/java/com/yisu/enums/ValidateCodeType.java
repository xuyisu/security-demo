/**
 *
 */
package com.yisu.enums;


import com.yisu.constants.FwCommonConstants;

/**
 * @author xuyisu
 *
 */
public enum ValidateCodeType {

	/**
	 * 短信验证码
	 */
	SMS {
		@Override
		public String getParamNameOnValidate() {
			return FwCommonConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
		}
	};

	/**
	 * 校验时从请求中获取的参数的名字
	 * @return
	 */
	public abstract String getParamNameOnValidate();

}
