package org.yjrc.service;

import java.util.List;

import org.yjrc.domain.Person;
import org.yjrc.models.PagedResult;
import org.yjrc.models.PersonInfoModel;

public interface PersonService {

	Person getPersonById(Integer id);
	
	List<Person> getAllPerson();
	
	void savePerson(PersonInfoModel model);
	
	PagedResult<Person> getPersonByRole(int pageIndex, int pageSize);
	
	/*
	 * "新增人员，只包含姓名、用户名、密码等基本信息"
	 */
	void createPerson(Person person);
	
	/*
	 * "用于判断身份证号是否存在"
	 */
	Integer getCountByNumberOfIdcard(String numberOfIdCard);
}
