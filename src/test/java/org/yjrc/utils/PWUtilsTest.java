package org.yjrc.utils;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PWUtilsTest {
	
	@Autowired
	private MyConfig myConfig;

	@Test
	public void testGenerateSecurePassword() {
		String pw = "123456";			
		String securePw = PWUtils.generateSecurePassword(pw, myConfig.getSalt());
		Assert.assertEquals(securePw, "RlwDPFZVk7yKaEUuj26+rnbakanvDXoZNIpyaUuj7ek=");		
	}

}
