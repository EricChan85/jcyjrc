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
	
	/*
	 * "新增人员，只包含姓名、用户名、密码等基本信息"
	 */
	void createPerson(Person person);
	
	/*
	 * "用于判断身份证号是否存在"
	 */
	Integer getCountByNumberOfIdcard(String numberOfIdCard);
	
	/*
	 * "保存个人简介"
	 */
	void saveProfile(Person person);
	
	/*
	 * "随机获取3个个人简介"
	 */
	List<Person> get3RandPersonWithProfile();
}
