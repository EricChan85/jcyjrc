package org.yjrc.utils;


import org.junit.Test;
import org.springframework.util.Assert;

public class MyStringsTest {

	@Test
	public void testDateStringToString() {
		Assert.isTrue("1990.02".contentEquals(MyStrings.dateStringToString("1990-02-02")));
	}

	
	@Test
	public void containsCharacterAndNumberTest() {
		Assert.isTrue(MyStrings.containsOnlyCharacterAndNumber("xiao6_Xiao"));
		Assert.isTrue(!MyStrings.containsOnlyCharacterAndNumber("xiaO-2019"));
		Assert.isTrue(!MyStrings.containsOnlyCharacterAndNumber("xiaming@163"));
	}
}
