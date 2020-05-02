package org.yjrc.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.yjrc.config.AuthenticationFacade;
import org.yjrc.domain.Activity;
import org.yjrc.domain.User;
import org.yjrc.enums.ActivityStatus;
import org.yjrc.models.ActivityModel;
import org.yjrc.models.PagedResult;
import org.yjrc.service.ActivityService;
import org.yjrc.service.EnumsService;
import org.yjrc.utils.ConstantsUtils;

@Controller
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private EnumsService enumsService;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	@RequestMapping(value="/admin/activity/list", method = RequestMethod.GET)
	public ModelAndView personList(@RequestParam(name="page", required = false) Integer pageIndex,
			@RequestParam(name="status", required = false) Integer status) {		
		if (pageIndex == null) {
			pageIndex = 1;
		}
		if (status == null) {
			status = ActivityStatus.PUBLISHED.getValue();
		}
		int pageSize = 20;
		ModelAndView mav = new ModelAndView();
		
		Map<Integer, String> statusItems = enumsService.getStatusItemsByKey(ConstantsUtils.getActivityStatusKey());
		mav.addObject("statusItems", statusItems);
		mav.addObject("status", status);
		PagedResult<ActivityModel> result = this.activityService.getByStatus(status, pageIndex, pageSize);
		mav.addObject("result", result);
		return mav;
	}
	
	@RequestMapping(value="/admin/activity/add", method = RequestMethod.GET)
	public ModelAndView addActivity(@RequestParam(name="success", required = false) Integer success) {		
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("activity", new ActivityModel());		
		if (success != null && success == 1) {
			mav.addObject("result", "保存成功！");
		}
		return mav;
	}
	
	@RequestMapping(value="/admin/activity/addActivity", method = RequestMethod.POST)
	public String addActivity(@ModelAttribute("activity") @Validated ActivityModel model,
							BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "/admin/activity/add";
		}
		Activity activity = new Activity(); 
		BeanUtils.copyProperties(model, activity);
		activity.setCreateTime(new Date());
		User user = authenticationFacade.getLoginUser();
		activity.setCreatorId(user.getId());
		activity.setStatus(ActivityStatus.UNPUBLISHED.getValue());
		this.activityService.createActivity(activity);
		return "redirect:/admin/activity/add?success=1";
	}
	
	@RequestMapping(value="/admin/activity/publish", method = RequestMethod.GET)
	public @ResponseBody String publish(@RequestParam(name="id", required = false) Integer id) {		
		if (id == null) {
			return "error";
		}
		Activity activity = new Activity();
		activity.setId(id);
		activity.setStatus(ActivityStatus.PUBLISHED.getValue());
		this.activityService.updateActivity(activity);
		return "success";
	}
	
	@RequestMapping(value="/activity", method = RequestMethod.GET)
	public ModelAndView viewActivity(@RequestParam(name="id", required = false) Integer id) {		
		ModelAndView mav = new ModelAndView();		
		if (id == null) {
			mav.addObject("msg", "该活动不存在，请刷新重试！");
		} else {
			Activity activity = this.activityService.getById(id);
			if (activity == null || activity.getStatus() != ActivityStatus.PUBLISHED.getValue()) {
				mav.addObject("msg", "该活动不存在，请刷新重试！");
			} else {
				ActivityModel model = new ActivityModel();
				BeanUtils.copyProperties(activity, model);
				mav.addObject("activity", model);
				
				List<ActivityModel> list = this.activityService.getRecent();
				list.removeIf(a -> a.getId().equals(id));
				mav.addObject("activityList", list);
			}
		}

		
		
		
		return mav;
	}
}
