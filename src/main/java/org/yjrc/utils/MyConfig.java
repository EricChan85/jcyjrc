package org.yjrc.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {

	@Value("${identifier:EqdmPh53c9x33EygXpTpcoJvc4VXLK}")
	private String salt;
	
	/*public MyConfig() {
		System.out.println("myconfig");
	}*/

	public String getSalt() {
		return salt;
	}
}
