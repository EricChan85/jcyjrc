package org.yjrc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.yjrc.models.PasswordModel;
import org.yjrc.service.UserService;

@Controller
@RequestMapping(value="/settings")
public class PasswordController {

	@Autowired
	private UserService	userService;
	
	@Autowired
	@Qualifier("passwordModelValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	/*
	 * 修改密码页
	 */
	@RequestMapping(value="/changePassword", method=RequestMethod.GET)
	public ModelAndView toChangePasswordPage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pwModel", new PasswordModel());
		return mav;
	}
	
	@RequestMapping(value="/savePW", method = RequestMethod.POST)
	public String doChangePassword(@ModelAttribute("pwModel") @Validated PasswordModel pwModel, 
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "/user/changePassword";
		}
		
		userService.changePassword(pwModel);
		HttpServletRequest request =
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		            .getRequest();
		new SecurityContextLogoutHandler().logout(request, null, null);
		return "redirect:/login";
	}
}
