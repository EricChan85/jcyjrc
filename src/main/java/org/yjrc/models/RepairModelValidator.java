package org.yjrc.models;

import java.text.ParseException;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.yjrc.utils.DateUtils;

public class RepairModelValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {		 
		return RepairModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		RepairModel model = (RepairModel)target;
						
		if (model.getDetails().isEmpty()) {
			errors.rejectValue("details", "required.details", "维修事项不能为空！");
			return;
		} 
		if (model.getStartTime().isEmpty()) {
			errors.rejectValue("startTime", "required.startTime", "预约维修开始时间不能为空！");
			return;
		}
		boolean isInvalidedStartTime = false;
		try {
			DateUtils.getDateFormat().parse(model.getStartTime());
		} catch(ParseException pe) {
			isInvalidedStartTime = true;
		}
		if (isInvalidedStartTime) {
			errors.rejectValue("startTime", "invalid.startTime", "预约维修开始时间错误！");
			return;
		} 
		if (model.getEndTime().isEmpty()) {
			errors.rejectValue("endTime", "required.endTime", "预约维修结束时间不能为空！");
			return;
		}
		boolean isInvalidedEndTime = false;
		try {
			DateUtils.getDateFormat().parse(model.getEndTime());
		} catch(ParseException pe) {
			isInvalidedEndTime = true;
		}
		if (isInvalidedEndTime) {
			errors.rejectValue("endTime", "invalid.endTime", "预约维修结束时间错误！");
			return;
		} 
		if (model.getAddress().isEmpty()) {
			errors.rejectValue("address", "required.address", "维修地址不能为空！");
			return;
		}
		if (model.getPhone().isEmpty()) {
			errors.rejectValue("phone", "required.phone", "维修联系电话不能为空！");
			return;
		}
	}

}
