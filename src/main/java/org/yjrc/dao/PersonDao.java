package org.yjrc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.yjrc.domain.Person;

public interface PersonDao {

	Person getPersonById(Integer id);
	
	List<Person> getAllPerson();
	
	Integer getPersonCountByRole(@Param("role")String role);
	
	List<Person> getPersonByRole(@Param("role")String role, 
			@Param("offset")int offset, @Param("count")int count);
		
	
	void savePerson(Person person);
}
