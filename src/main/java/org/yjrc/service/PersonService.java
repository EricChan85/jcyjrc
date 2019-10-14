package org.yjrc.service;

import java.util.List;

import org.yjrc.domain.Person;

public interface PersonService {

	Person getPersonById(Integer id);
	
	List<Person> getAllPerson();
}
