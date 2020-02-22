package org.yjrc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yjrc.models.UserModel;

@Controller
@RequestMapping
public class LoginController {
	
	
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

}
