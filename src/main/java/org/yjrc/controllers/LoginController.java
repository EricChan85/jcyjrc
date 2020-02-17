package org.yjrc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yjrc.models.UserModel;
import org.yjrc.service.PersonService;

@Controller
@RequestMapping
public class LoginController {

	@Autowired
	private PersonService personService;	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView toLoginPage(@RequestParam(name="error", required = false) boolean error) {		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new UserModel());		
		if (error) {
			mav.addObject("msg", "用户名或密码错误！");
		}
		mav.setViewName("login");
		return mav;
	}
	
	/*@RequestMapping(value="/login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("user")UserModel user, Model model) {
		String userName = user.getUserName();
		Person person = personService.isValidPerson(user.getUserName(), user.getPassword());
		if (person != null) {
			return "redirect:/welcome";
		} 
		model.addAttribute("error", "用户名或密码错误！");
		return "login";
	}*/
}
