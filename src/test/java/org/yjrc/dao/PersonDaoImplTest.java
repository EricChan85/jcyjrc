package org.yjrc.dao;


import static org.junit.Assert.assertTrue;

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
	
	/*@Test
	public void testSavePerson() {
		int id = 2;
		String name = "李雷1";
		Person person = new Person();
		person.setId(id);
		person.setName("李雷1");
		person.setGender('M');
		person.setDateOfBirth("1990.01.01");
		person.setBirthPlace(birthPlace);
		personDao.savePerson(person);
		person = personDao.getPersonById(id);
		Assert.assertTrue(name.equals(person.getName()));
	}*/
	
	
	@Test 
	public void getPersonCountByRoleTest() {
		int count = personDao.getPersonCountByRole("ROLE_USER");
		Assert.assertTrue(count > 0);;
	}
	
	@Test 
	public void getPersonByRoleTest() {
		List<Person> list = personDao.getPersonByRole("ROLE_USER", 0 , 10);
		Assert.assertFalse(list.isEmpty());
	}
	
	@Test
	public void createPersonTest() {
		Person person = new Person();
		person.setName("小王");
		person.setUserName("xiaoWang");
		person.setPassword("$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS");
		person.setNumberOfIdCard("620321198903050626");
		person.setRole("ROLE_USER");
		this.personDao.createPerson(person);
	}
	
	@Test
	public void getCountByNumberOfIdcardTest() {
		Integer count = this.personDao.getCountByNumberOfIdcard("620321199003080879");
		assertTrue(count != null && count > 0);
	}
	
	@Test
	public void get3RandPersonWithProfileTest() {
		List<Person> list = this.personDao.get3RandPersonWithProfile();
		assertTrue(list.size() == 1);
	}
}
