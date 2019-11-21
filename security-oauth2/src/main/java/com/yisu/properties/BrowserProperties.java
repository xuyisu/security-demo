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

	private LoginResponseType loginType = LoginResponseType.JSON;

}
