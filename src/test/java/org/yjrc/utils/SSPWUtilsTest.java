package org.yjrc.utils;

import org.junit.Assert;
import org.junit.Test;

public class SSPWUtilsTest {

	@Test
	public void test() {
		boolean boolVal = SSPWUtils.tt("123456"); 
		Assert.assertTrue(boolVal);
	}

}
