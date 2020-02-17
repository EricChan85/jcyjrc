package org.yjrc.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yjrc.dao.PersonDao;
import org.yjrc.domain.Person;
import org.yjrc.models.PersonInfoModel;
import org.yjrc.utils.MyConfig;
import org.yjrc.utils.PWUtils;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private MyConfig myConfig;
	
	public Person getPersonById(Integer id) {
		return this.personDao.getPersonById(id);
	}
	
	public List<Person> getAllPerson() {
		return this.personDao.getAllPerson();
	}
	
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
}
