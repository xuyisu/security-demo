/**
 *
 */
package com.yisu.properties;

import lombok.Data;

/**
 * @author xuyisu
 *
 */
@Data
public class SocialsProperties {

	private String filterProcessesUrl = "/auth";

	private QQProperties qq = new QQProperties();



}
