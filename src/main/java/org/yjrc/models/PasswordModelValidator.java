package org.yjrc.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.yjrc.config.AuthenticationFacade;
import org.yjrc.domain.User;
import org.yjrc.utils.SSPWUtils;

public class PasswordModelValidator implements Validator {

	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return PasswordModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
				
		User user = authenticationFacade.getLoginUser();
		
		PasswordModel model = (PasswordModel)target;
		if (model.getOldPassword().isEmpty()) {
			errors.rejectValue("oldPassword", "required.oldPassword", "旧密码不能为空！");
		} else if (!SSPWUtils.matches(model.getOldPassword(), user.getPassword())) {
			errors.rejectValue("oldPassword", "invalideOldPassword", "旧密码错误！");
		} else if (model.getNewPassword().length() < 6) {
			errors.rejectValue("newPassword", "invalidPassword", "密码不能小于6位！");
		} else if (!model.getNewPassword().equals(model.getConfirmedPassword())) {
			errors.rejectValue("confirmedPassword", "errorPassword", "两次输入的密码不一致！");
		}
	}

}
