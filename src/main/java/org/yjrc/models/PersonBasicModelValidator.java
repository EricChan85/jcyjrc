package org.yjrc.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.yjrc.service.PersonService;
import org.yjrc.service.UserService;
import org.yjrc.utils.MyStrings;
import org.yjrc.utils.NumberOfIdCardUtils;

public class PersonBasicModelValidator implements Validator {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PersonService personService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return PersonBasicModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {


		PersonBasicModel model = (PersonBasicModel)target;
		if (MyStrings.isEmpty(model.getName())) {
			errors.rejectValue("name", "required.name", "姓名为必填项！");
		} else if (MyStrings.isEmpty(model.getUserName()) || model.getUserName().length() < 6) {
			errors.rejectValue("userName", "required.userName", "用户名不能少于6位！");
		} else if (this.userService.getUserByUserName(model.getUserName()) != null) {
			errors.rejectValue("userName", "existed.userName", "用户名已存在！");
		} else if (!MyStrings.containsOnlyCharacterAndNumber(model.getUserName())) {
			errors.rejectValue("userName", "invalid.userName", "用户名只能由字母数字下划线组成！");
		} else if (MyStrings.isEmpty(model.getNumberOfIdCard())) {
			errors.rejectValue("numberOfIdCard", "required.numberOfIdCard", "身份证号为必填项！");
		} else if (!NumberOfIdCardUtils.isValid(model.getNumberOfIdCard())) {
			errors.rejectValue("numberOfIdCard", "invalid.numberOfIdCard", "身份证号错误！");
		} else {
			Integer count = this.personService.getCountByNumberOfIdcard(model.getNumberOfIdCard());
			if (count != null && count > 0) {
				errors.rejectValue("numberOfIdCard", "existed.numberOfIdCard", "身份证号已注册！");
			}
		}
		
	}

}
