package org.yjrc.utils;


import org.junit.Test;
import org.springframework.util.Assert;

public class MyStringsTest {

	@Test
	public void testDateStringToString() {
		Assert.isTrue("1990.02".contentEquals(MyStrings.dateStringToString("1990-02-02")));
	}

}
