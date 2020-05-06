package org.yjrc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yjrc.dao.PersonDao;
import org.yjrc.domain.Person;
import org.yjrc.domain.Repair;
import org.yjrc.models.PagedResult;
import org.yjrc.models.PersonInfoModel;
import org.yjrc.models.RepairModel;
import org.yjrc.utils.ConstantsUtils;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	
	
	
	private static final String ROLE_USER = "ROLE_USER";
	
	public Person getPersonById(Integer id) {
		return this.personDao.getPersonById(id);
	}
	
	public List<Person> getAllPerson() {
		return this.personDao.getAllPerson();
	}
	
	@Transactional
	public void savePerson(PersonInfoModel model) {
		Person person = modelToPerson(model);
		this.personDao.savePerson(person);		
	}
	
	private Person modelToPerson(PersonInfoModel model) {
		Person person = new Person();
		person.setId(model.getId());
		person.setName(model.getName());
		person.setGender(model.getGender());
		if (model.getDateOfBirth() != null && !model.getDateOfBirth().isEmpty()) {
			person.setDateOfBirth(model.getDateOfBirth().concat(".01"));
		}
		person.setNationality(model.getNationality());
		person.setNativePlace(model.getNativePlace());
		person.setBirthPlace(model.getBirthPlace());
		person.setPoliticalStatus(model.getPoliticalStatus());
		if (model.getDateOfJoiningTheParty() != null && !model.getDateOfJoiningTheParty().isEmpty()) {
			person.setDateOfJoiningTheParty(model.getDateOfJoiningTheParty().concat(".01"));
		}
		person.setEducation(model.getEducation());
		person.setHealthCondition(model.getHealthCondition());
		if (model.getDateOfStartingToWork() != null && !model.getDateOfStartingToWork().isEmpty()) {
			person.setDateOfStartingToWork(model.getDateOfStartingToWork().concat(".01"));
		}
		if (model.getDateOfEntering() != null && !model.getDateOfEntering().isEmpty()) {
			person.setDateOfEntering(model.getDateOfEntering().concat(".01"));
		}
		person.setNumberOfIdCard(model.getNumberOfIdCard());
		person.setPhone(model.getPhone());
		person.setInstitution(model.getInstitution());
		person.setPosition(model.getPosition());
		person.setProfessionalTechnicalPosition(model.getProfessionalTechnicalPosition());
		person.setAddress(model.getAddress());
		return person;
	}

	@Override
	public PagedResult<Person> getPersonByRole(int pageIndex, int pageSize) {
		int offset = (pageIndex - 1) * pageSize;
		Integer sum = personDao.getPersonCountByRole(ROLE_USER);
		if (sum == null) {
			sum = 0;
		}
		List<Person> list = personDao.getPersonByRole(ROLE_USER, offset, pageSize);		
		return new PagedResult<Person>(list, sum, pageIndex, pageSize);
	}

	@Override
	@Transactional
	public void createPerson(Person person) {
		this.personDao.createPerson(person);
		
	}

	@Override
	public Integer getCountByNumberOfIdcard(String numberOfIdCard) {		
		return this.personDao.getCountByNumberOfIdcard(numberOfIdCard);
	}

	@Override
	public void saveProfile(Person person) {
		this.personDao.saveProfile(person);		
	}

	@Override
	public List<Person> get3RandPersonWithProfile() {		
		return this.personDao.get3RandPersonWithProfile();
	}
	
	
}
