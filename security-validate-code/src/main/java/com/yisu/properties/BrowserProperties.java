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


	private String loginPage = "/imooc-signUp.html";


	private LoginResponseType loginType = LoginResponseType.JSON;



}
