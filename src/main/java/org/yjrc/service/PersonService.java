package org.yjrc.service;

import java.util.List;

import org.yjrc.domain.Person;
import org.yjrc.models.PagedResult;
import org.yjrc.models.PersonInfoModel;

public interface PersonService {

	Person getPersonById(Integer id);
	
	List<Person> getAllPerson();
	
	void savePerson(PersonInfoModel model);
	
	PagedResult<Person> getPersonByRole(int pageIndex, int count);
}
