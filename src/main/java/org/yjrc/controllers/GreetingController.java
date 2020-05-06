package org.yjrc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.yjrc.domain.Person;
import org.yjrc.models.ActivityModel;
import org.yjrc.service.ActivityService;
import org.yjrc.service.PersonService;

@Controller
@RequestMapping
public class GreetingController {

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	/*@ResponseBody*/
	public ModelAndView showWelcome(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		
		List<ActivityModel> list = this.activityService.getTop3Published();
		model.addObject("activityList", list);
		List<Person> personList = this.personService.get3RandPersonWithProfile();
		model.addObject("personWithProfile", personList);
		model.setViewName("welcome");
		return model;		
	}
}
