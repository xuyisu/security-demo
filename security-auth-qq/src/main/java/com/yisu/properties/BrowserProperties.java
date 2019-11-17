/**
 *
 */
package com.yisu.properties;

import com.yisu.enums.LoginResponseType;
import lombok.Data;

/**
 *
 * @Author xuyisu
 * @Date 2019/10/29
 * @Param
 * @Return
 */
@Data
public class BrowserProperties {


	private String loginPage = "/default-login.html";

	private String signUpUrl = "/default-signUp.html";

	private LoginResponseType loginType = LoginResponseType.JSON;


	private SessionProperties session = new SessionProperties();

	private int rememberMeSeconds = 3600;


}
