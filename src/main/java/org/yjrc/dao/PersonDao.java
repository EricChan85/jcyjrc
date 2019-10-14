package org.yjrc.dao;

import java.util.List;

import org.yjrc.domain.Person;

public interface PersonDao {

	Person getPersonById(Integer id);
	
	List<Person> getAllPerson();
}
