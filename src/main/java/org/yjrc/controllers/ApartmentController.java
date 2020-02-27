package org.yjrc.controllers;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import org.yjrc.service.EnumsService;
import org.yjrc.service.RepairService;
import org.yjrc.utils.ConstantsUtils;

@Controller
@RequestMapping(value="/apartment")
public class ApartmentController {

	@Autowired
	private RepairService repairService;
	
	@Autowired
	private EnumsService enumsService;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	@RequestMapping(value="/repair", method=RequestMethod.GET)
	public ModelAndView repairList(@RequestParam(name="page", required = false) Integer pageIndex,
			@RequestParam(name="status", required = false) Integer status) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		if (status == null) {
			status = RepairStatus.COMMITED.getValue();
		}
		int pageSize = 20;
		ModelAndView mav = new ModelAndView();
		PagedResult<RepairModel> result = this.repairService.getByStatus(status, pageIndex, pageSize);
		mav.addObject("result", result);		
		Map<Integer, String> statusItems = enumsService.getStatusItemsByKey(ConstantsUtils.getRepairStatusKey());
		mav.addObject("statusItems", statusItems);
		mav.addObject("status", status);
		return mav;
	}
	
	@RequestMapping(value="/saveDescription", method=RequestMethod.POST)
	public @ResponseBody String postDescription(@RequestParam("id") int id, 
								@RequestParam("description") String description) {
		Repair repair = this.repairService.getById(id);
		if (repair == null) {
			return "error";
		}
		repair.setRepairDescription(description);
		repair.setRepairTime(new Date());
		repair.setStatus(RepairStatus.REPAIRED.getValue());
		User user = authenticationFacade.getLoginUser();
		repair.setRepairmanId(user.getId());
		this.repairService.updateRepairDescription(repair);
		return "success";
	}
	

}
