package org.yjrc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class GreetingController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	/*@ResponseBody*/
	public ModelAndView showWelcome(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		return model;		
	}
}
