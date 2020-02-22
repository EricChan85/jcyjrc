package org.yjrc.controllers;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.yjrc.config.AuthenticationFacade;
import org.yjrc.domain.Repair;
import org.yjrc.domain.User;
import org.yjrc.models.RepairModel;
import org.yjrc.service.RepairService;

@Controller
@RequestMapping(value="/repair")
public class RepairController {

	@Autowired
	private RepairService repairService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	@RequestMapping(value="/myRepair")
	public ModelAndView myRepairHistory() {
		ModelAndView mav = new ModelAndView();
		User user = this.authenticationFacade.getLoginUser();
		List<Repair> list = this.repairService.getByPersonId(user.getId());
		List<RepairModel> modelList = list.stream().map(this::convertToModel).collect(Collectors.toList());
		mav.addObject("list", modelList);
		return mav;
	}
	
	private RepairModel convertToModel(Repair repair) {
		RepairModel model = modelMapper.map(repair, RepairModel.class);
	    model.setStartTime(repair.getStartTime());
	    model.setEndTime(repair.getEndTime());
	    model.setCreateTime(repair.getCreateTime());
	    return model;
	}
	
	private Repair convertToEntity(RepairModel model) throws ParseException {
		Repair repair = modelMapper.map(model, Repair.class);
		repair.setStartTime(model.getStartTimeConverted());
		repair.setEndTime(model.getEndTimeConverted());
		repair.setCreateTime(model.getCreateTimeConverted());
		return repair;
	}
}
