package org.yjrc.utils;

import org.junit.Assert;
import org.junit.Test;

public class SSPWUtilsTest {

	@Test
	public void matchesTest() {
		String encoded = SSPWUtils.encode("123456");
		boolean boolVal = SSPWUtils.matches("123456", "$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS");
		/*boolVal = SSPWUtils.matches("123456", encoded);*/
		Assert.assertTrue(boolVal);
	}

}
