package org.yjrc.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.yjrc.domain.Person;
import org.yjrc.models.PersonBasicModel;

public class PersonControllerTest {

	@Test
	public void convertToEntityTest() {
		ModelMapper modelMapper = new ModelMapper();
		PersonBasicModel model = new PersonBasicModel();
		model.setName("sss");
		model.setUserName("sss");
		model.setNumberOfIdCard("sss");
		Person p = modelMapper.map(model, Person.class);
		assertEquals(p.getName(), model.getName());
		assertEquals(p.getNumberOfIdCard(), model.getNumberOfIdCard());	
	}
	
	@Test
	public void test() {
		String str = "ss";
		String str1 = "ss";
		assertEquals(str, str1);
	}

}
