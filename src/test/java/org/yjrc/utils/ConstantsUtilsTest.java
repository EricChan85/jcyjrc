package org.yjrc.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConstantsUtilsTest {

	@Test
	public void getNationalityKeyTest() {
		assertEquals(ConstantsUtils.getNationalityKey(), "nationality");
	}

}
