/**
 *
 */
package com.yisu.validate.filter;

import com.yisu.properties.SecurityProperties;
import com.yisu.validate.exception.ValidateCodeException;
import com.yisu.validate.image.ImageCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xuyisu
 *
 */
@Component("validateCodeFilter")
@Data
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

	/**
	 * 验证码校验失败处理器
	 */
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	private final String SESSION_KEY="SESSION_KEY_IMAGE_CODE";

	/**
	 * 操作session的工具类
	 */
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	/**
	 * 系统配置信息
	 */
	@Autowired
	private SecurityProperties securityProperties;
//	/**
//	 * 系统中的校验码处理器
//	 */
//	@Autowired
//	private ValidateCodeProcessorHolder validateCodeProcessorHolder;
//	/**
//	 * 存放所有需要校验验证码的url
//	 */
//	private Map<String, ValidateCodeType> urlMap = new HashMap<>();
	/**
	 * 验证请求url与配置的url是否匹配的工具类
	 */
	private AntPathMatcher pathMatcher = new AntPathMatcher();

	/**
	 * 初始化要拦截的url配置信息
	 */
	@Override
	public void afterPropertiesSet() throws ServletException {
		super.afterPropertiesSet();

//		urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM, ValidateCodeType.IMAGE);
//		addUrlToMap(securityProperties.getCode().getImage().getUrl(), ValidateCodeType.IMAGE);
//
//		urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE, ValidateCodeType.SMS);
//		addUrlToMap(securityProperties.getCode().getSms().getUrl(), ValidateCodeType.SMS);
	}

	/**
	 * 讲系统中配置的需要校验验证码的URL根据校验的类型放入map
	 *
	 * @param urlString
	 * @param type
	 */
//	protected void addUrlToMap(String urlString, ValidateCodeType type) {
//		if (StringUtils.isNotBlank(urlString)) {
//			String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(urlString, ",");
//			for (String url : urls) {
////				urlMap.put(url, type);
//			}
//		}
//	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

//		ValidateCodeType type = getValidateCodeType(request);
//		if (type != null) {
//			logger.info("校验请求(" + request.getRequestURI() + ")中的验证码,验证码类型" + type);
//			try {
//				validateCodeProcessorHolder.findValidateCodeProcessor(type)
//						.validate(new ServletWebRequest(request, response));
//				logger.info("验证码校验通过");
//			} catch (ValidateCodeException exception) {
//				authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
//				return;
//			}
//		}
		if(StringUtils.equals("/authentication/form",request.getRequestURI())&&StringUtils.endsWithIgnoreCase(request.getMethod(),"POST")){
			try {
				validate(new ServletWebRequest(request));
			}catch (ValidateCodeException exception)
			{
				authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
				return;
			}
		}

		chain.doFilter(request, response);

	}

	private void validate(ServletWebRequest request) {

		ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request, SESSION_KEY);

		String codeInRequest;
		try {
			codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),
					"imageCode");
		} catch (ServletRequestBindingException e) {
			throw new ValidateCodeException("获取验证码的值失败");
		}

		if (StringUtils.isBlank(codeInRequest)) {
			throw new ValidateCodeException("验证码的值不能为空");
		}

		if (codeInSession == null) {
			throw new ValidateCodeException("验证码不存在");
		}

		if (codeInSession.isExpried()) {
			sessionStrategy.removeAttribute(request, SESSION_KEY);
			throw new ValidateCodeException("验证码已过期");
		}

		if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
			throw new ValidateCodeException("验证码不匹配");
		}

		sessionStrategy.removeAttribute(request, SESSION_KEY);
	}

	/**
	 * 获取校验码的类型，如果当前请求不需要校验，则返回null
	 *
	 * @param request
	 * @return
	 */
//	private ValidateCodeType getValidateCodeType(HttpServletRequest request) {
//		ValidateCodeType result = null;
//		if (!StringUtils.equalsIgnoreCase(request.getMethod(), "get")) {
//			Set<String> urls = urlMap.keySet();
//			for (String url : urls) {
//				if (pathMatcher.match(url, request.getRequestURI())) {
//					result = urlMap.get(url);
//				}
//			}
//		}
//		return result;
//	}

}
