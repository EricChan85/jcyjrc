package org.yjrc.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.yjrc.domain.Enums;


@ContextConfiguration({"classpath:/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EnumsServiceImplTest {

	@Autowired
	private EnumsService enumsService;
	
	@Test
	public void getAllNationalityTest() {
		List<Enums> list = enumsService.getAllNationality();
		Assert.isTrue(list.size() == 56);
	}
	
	@Test
	public void getAllNationalityItemsTest() {
		Map<Integer, String> items = enumsService.getAllNationalityItems();
		Assert.isTrue(items.size() == 56);
	}
	
	@Test
	public void getAllPoliticalStatusItemsTest() {
		Map<Integer, String> items = enumsService.getAllPoliticalStatusItems();
		Assert.isTrue(items.size() == 13);
	}

}
