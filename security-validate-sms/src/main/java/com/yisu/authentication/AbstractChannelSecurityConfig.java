/**
 *
 */
package com.yisu.authentication;

import com.yisu.constants.FwCommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author zhailiang
 *
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	protected AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

	@Autowired
	protected AuthenticationFailureHandler imoocAuthenticationFailureHandler;

	protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(FwCommonConstants.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(FwCommonConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
			.successHandler(imoocAuthenticationSuccessHandler)
			.failureHandler(imoocAuthenticationFailureHandler);
	}

}
