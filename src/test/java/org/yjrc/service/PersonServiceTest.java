package org.yjrc.service;



import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yjrc.domain.Person;

@ContextConfiguration({"classpath:/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {

	@Autowired
	PersonService service;
	
	@Test
	public void testGetPersonById() {		
		Person person = service.getPersonById(1);
		System.out.println(person.getName());
		Assert.assertNotNull(person);
	}

	@Test
	public void testGetAllPerson() {
		List<Person> list = service.getAllPerson();
		Assert.assertFalse(list.isEmpty());
		System.out.println(list.size());
	}
	
}
