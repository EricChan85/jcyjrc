package org.yjrc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yjrc.dao.PersonDao;
import org.yjrc.domain.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	public Person getPersonById(Integer id) {
		return this.personDao.getPersonById(id);
	}
	
	public List<Person> getAllPerson() {
		return this.personDao.getAllPerson();
	}
}
