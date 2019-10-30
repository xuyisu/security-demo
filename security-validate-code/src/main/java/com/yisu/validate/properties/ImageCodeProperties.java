package com.yisu.validate.properties;

import lombok.Data;

/**
 * @author xuyisu
 *
 */
@Data
public class ImageCodeProperties{

	private int length = 6;
	private int expireIn = 60;
	private int width = 67;
	private int height = 23;


}
