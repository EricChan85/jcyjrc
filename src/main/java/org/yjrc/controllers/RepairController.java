package org.yjrc.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.yjrc.config.AuthenticationFacade;
import org.yjrc.domain.Repair;
import org.yjrc.domain.User;
import org.yjrc.enums.RepairStatus;
import org.yjrc.models.PagedResult;
import org.yjrc.models.RepairModel;
import org.yjrc.models.WorkExperienceModel;
import org.yjrc.service.EnumsService;
import org.yjrc.service.RepairService;
import org.yjrc.utils.ConstantsUtils;

@Controller
@RequestMapping(value="/repair")
public class RepairController {

	@Autowired
	private RepairService repairService;
	
	@Autowired
	private EnumsService enumsService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	@Autowired
	@Qualifier("repairModelValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value="/myRepair", method=RequestMethod.GET)
	public ModelAndView myRepairHistory() {
		ModelAndView mav = new ModelAndView();
		User user = this.authenticationFacade.getLoginUser();
		List<Repair> list = this.repairService.getByPersonId(user.getId());
		List<RepairModel> modelList = this.repairService.convertToModelList(list);//.stream().map(this::convertToModel).collect(Collectors.toList());
		mav.addObject("list", modelList);		
		return mav;
	}
	
	@RequestMapping(value="/newRepair", method=RequestMethod.GET)
	public ModelAndView toRepair() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("model", new RepairModel());
		return mav;
	}
	
	@RequestMapping(value="/createRepair", method = RequestMethod.POST)
	public String postRepairModel(@ModelAttribute("model") @Validated RepairModel model, 
						BindingResult bindingResult, Model m) throws ParseException {
		if (bindingResult.hasErrors()) {
			return "/repair/newRepair";
		}
		
		User user = authenticationFacade.getLoginUser();
		Repair repair = convertToEntity(model);
		repair.setStatus(RepairStatus.COMMITED.getValue());
		repair.setPersonId(user.getId());
		repair.setCreateTime(new Date());
		
		this.repairService.createRepair(repair);
		return "redirect:/repair/myRepair";
	}	
	
	private Repair convertToEntity(RepairModel model) throws ParseException {
		Repair repair = new Repair();
		repair.setDetails(model.getDetails());
		repair.setStartTime(model.getStartTimeConverted());
		repair.setEndTime(model.getEndTimeConverted());
		repair.setAddress(model.getAddress());
		repair.setPhone(model.getPhone());
		repair.setCreateTime(new Date());
		return repair;
	}
	
	@RequestMapping(value="/saveEvaluation", method=RequestMethod.POST)
	public @ResponseBody String postEvaluation(@RequestParam("id") int id, 
								@RequestParam("evaluation") String evaluation) {
		Repair repair = this.repairService.getById(id);
		if (repair == null) {
			return "error";
		}
		repair.setEvaluation(evaluation);
		repair.setEvaluationTime(new Date());
		repair.setStatus(RepairStatus.EVALUATED.getValue());
		this.repairService.updateEvaluation(repair);
		return "success";
	}
	
}
