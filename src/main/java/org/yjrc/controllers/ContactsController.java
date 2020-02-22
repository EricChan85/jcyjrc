package org.yjrc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yjrc.domain.Person;
import org.yjrc.models.PagedResult;
import org.yjrc.service.PersonService;

@Controller
@RequestMapping(value="/contacts")
public class ContactsController {

	@Autowired
	private PersonService personService;
	
	
	/*
	 * 通讯录，适合人员比较少的情况
	 */
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public String contactsPage(@RequestParam(name="page", required = false) Integer pageIndex, Model model) {
		if (pageIndex == null || pageIndex <= 0) {
			pageIndex = 1;
		}
		PagedResult<Person> result = personService.getPersonByRole(pageIndex, 10);
		model.addAttribute("result", result);
		return "/contacts/contacts";
	}
}
