/**
 * 
 */
package com.yisu.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @author xuyisu
 *
 */

@EnableOAuth2Sso
@SpringBootApplication
public class FwSsoClient1Application {
	

	public static void main(String[] args) {
		SpringApplication.run(FwSsoClient1Application.class, args);
	}
	
}
