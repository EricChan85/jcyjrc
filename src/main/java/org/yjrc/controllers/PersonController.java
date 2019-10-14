package org.yjrc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yjrc.domain.Person;
import org.yjrc.service.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping
public class PersonController {
		
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showWelcome(Model model) {
		model.addAttribute("word", "welcome");
		return "welcome";
	}
	
	/*
	 * 查看人员列表
	 */
	@RequestMapping(value="/viewPersonList", method = RequestMethod.GET)
	public String showPersonList(Model model) {
		List<Person> personList = personService.getAllPerson();
		model.addAttribute("lists", personList);
		model.addAttribute("person1", "bb");//personList.get(0).getId());
		return "viewPersonList";
	}
	
	@RequestMapping("/showperson")
	public String showperson(Model m) {
		m.addAttribute("command", new Person());
		return "showperson";
	}

}
