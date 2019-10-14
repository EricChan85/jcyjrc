package org.yjrc.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.test.annotation.DirtiesContext;*/
import org.springframework.test.context.ContextConfiguration;
/*import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;*/
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yjrc.domain.Person;


/*@DirtiesContext
@SpringJUnitConfig(locations = { "classpath:spring-config.xml" })*/
@ContextConfiguration({"classpath:/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonDaoImplTest {

	@Autowired
	private PersonDao personDao;
	
	
	@Test
	public void testGetPersonById() {
		
		Person person = personDao.getPersonById(1);
		Assert.assertNotNull(person);
		System.out.println(person.getName());
	}
	
	@Test 
	public void testGetAllPerson() {
		List<Person> list = personDao.getAllPerson();
		Assert.assertFalse(list.isEmpty());
	}

}
