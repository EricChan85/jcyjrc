package org.yjrc.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.yjrc.domain.Enums;


@ContextConfiguration({"classpath:/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EnumsDaoTest {

	@Autowired
	private EnumsDao enumsDao;
	
	@Test
	public void getEnumsByTypeTest() {
		List<Enums> list = enumsDao.getEnumsByType("nationality");
		Assert.isTrue(list.size() == 56);
	}
	
	@Test
	public void getEnumsNameByTypeTest() {
		List<String> list = enumsDao.getEnumsNameByType("nationality");
		Assert.isTrue(list.size() == 56);
	}

}
