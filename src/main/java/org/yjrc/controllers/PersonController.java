package org.yjrc.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.yjrc.config.AuthenticationFacade;
import org.yjrc.domain.EducationExperiences;
import org.yjrc.domain.Person;
import org.yjrc.domain.User;
import org.yjrc.domain.WorkExperience;
import org.yjrc.models.EducationExperienceModel;
import org.yjrc.models.PersonInfoModel;
import org.yjrc.models.WorkExperienceModel;
import org.yjrc.service.EducationExperiencesService;
import org.yjrc.service.EnumsService;
import org.yjrc.service.PersonService;
import org.yjrc.service.WorkExperienceService;
import org.yjrc.utils.MyStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class PersonController {
		
	@Autowired
	private PersonService personService;
	
	@Autowired
	private EnumsService enumsService;
	
	@Autowired
	private EducationExperiencesService educationExperiencesService;
	
	@Autowired
	private WorkExperienceService workExperienceService;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	
	@RequestMapping(value="/userInfo", method = RequestMethod.GET)
	public ModelAndView editUserPage(@RequestParam(name="error", required = false) boolean error) {		
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("person", createModel());
		
		Map<Integer, String> nationalityItems = enumsService.getAllNationalityItems();
		mav.addObject("nationalityItems", nationalityItems);
		Map<Integer, String> politicalStatusItems = enumsService.getAllPoliticalStatusItems();
		mav.addObject("politicalStatusItems", politicalStatusItems);
		if (error) {
			mav.addObject("msg", "用户名或密码错误！");
		}
		/*mav.setViewName("userInfo");*/
		return mav;
	}
		
	public PersonInfoModel createModel() {
		PersonInfoModel model = new PersonInfoModel();
		User user = authenticationFacade.getLoginUser();
		if (user != null) {
			
			Person person = personService.getPersonById(user.getId());
			if (person != null) {
				model.setId(user.getId());
				model.setName(person.getName());
				model.setGender(person.getGender());
				String dateOfBirth =  MyStrings.dateStringToString(person.getDateOfBirth());
				model.setDateOfBirth(dateOfBirth);
				model.setNationality(person.getNationality());
				model.setNativePlace(person.getNativePlace());
				model.setBirthPlace(person.getBirthPlace());
				model.setPoliticalStatus(person.getPoliticalStatus());
				String dateOfJoiningTheParty = MyStrings.dateStringToString(person.getDateOfJoiningTheParty());
				model.setDateOfJoiningTheParty(dateOfJoiningTheParty);
				model.setEducation(person.getEducation());
				model.setHealthCondition(person.getHealthCondition());
				String dateOfStartingToWork = MyStrings.dateStringToString(person.getDateOfStartingToWork());
				model.setDateOfStartingToWork(dateOfStartingToWork);
				String dateOfEntering = MyStrings.dateStringToString(person.getDateOfEntering());
				model.setDateOfEntering(dateOfEntering);
				model.setNumberOfIdCard(person.getNumberOfIdCard());
				model.setPhone(person.getPhone());
				model.setInstitution(person.getInstitution());
				model.setPosition(person.getPosition());
				model.setProfessionalTechnicalPosition(person.getProfessionalTechnicalPosition());
				model.setAddress(person.getAddress());
			}
		}
		return model;
	}
	
	
	@RequestMapping(value="/savePerson", method = RequestMethod.POST)
	public String savePerson(@ModelAttribute("person")PersonInfoModel person, Model model) {
			
		this.personService.savePerson(person);
		return "redirect:/user/userInfo";
	}
	
	/*
	 * 查看人员列表
	 */
	@RequestMapping(value="/viewPersonList", method = RequestMethod.GET)
	public String showPersonList(Model model) {
		/*List<Person> personList = personService.getAllPerson();
		model.addAttribute("lists", personList);
		model.addAttribute("person1", "bb");//personList.get(0).getId());
*/		return "viewPersonList";
	}
	
	/*
	 * 教育经历页
	 */
	@RequestMapping(value="/educationExperience", method = RequestMethod.GET)
	public ModelAndView toEducationExperiencePage() {
		ModelAndView mav = new ModelAndView();
		User user = authenticationFacade.getLoginUser();
		if (user != null) {
			mav.addObject("personId", user.getId());
			List<EducationExperiences> list = educationExperiencesService.getEducationExperiencesByPersonId(user.getId());
			mav.addObject("modelList", educationExperienceToModel(list));
		
		}
		return mav;
	}
	
	private List<EducationExperienceModel> educationExperienceToModel(List<EducationExperiences> list) {
		List<EducationExperienceModel> modelList = new ArrayList<EducationExperienceModel>();
		if (list != null && list.size() > 0) {
			
			for (int i = 0; i < list.size(); i++) {
				EducationExperiences ee = list.get(i);
				EducationExperienceModel model = new EducationExperienceModel();
				String startDate = MyStrings.dateStringToString(ee.getStartDate());
				model.setStartDate(startDate);
				model.setEndDate(MyStrings.dateStringToString(ee.getEndDate()));
				model.setDetails(ee.getDetails());
				modelList.add(model);
			}
			
		}
		return modelList;
	}

	//教育经历 
	@RequestMapping(value="/saveEE", method = RequestMethod.POST)
	public @ResponseBody String postEducationExperiences(@RequestBody List<EducationExperienceModel> modelList) {
		User user = authenticationFacade.getLoginUser();
		int personId = user.getId();
		educationExperiencesService.saveEducationExperiences(personId, modelToEducationExperience(personId, modelList));
		return "success";
	}
	
	private List<EducationExperiences> modelToEducationExperience(int personId, List<EducationExperienceModel> modelList) {
		List<EducationExperiences> list = new ArrayList<EducationExperiences>();
		if (modelList != null && modelList.size() > 0) {
			
			for (int i = 0; i < modelList.size(); i++) {
				EducationExperienceModel model = modelList.get(i);
				EducationExperiences ee = new EducationExperiences();
				ee.setPersonId(personId);
				if (model.getStartDate() != null && !model.getStartDate().isEmpty()) {
					ee.setStartDate(model.getStartDate().concat("01"));
				}
				if (model.getEndDate() != null && !model.getEndDate().isEmpty()) {
					ee.setEndDate(model.getEndDate().concat("01"));
				}				
				ee.setDetails(model.getDetails());
				list.add(ee);
			}
			
		}
		return list;
	}
	
	/**
	 * 工作经历页
	 * @return
	 */
	@RequestMapping(value="/workExperience", method= RequestMethod.GET)
	public ModelAndView toWorkExperiencePage() {
		ModelAndView mav = new ModelAndView();
		User user = authenticationFacade.getLoginUser();
		if (user != null) {
			mav.addObject("personId", user.getId());
			List<WorkExperience> list = workExperienceService.getWorkExperiencesByPersonId(user.getId());
			mav.addObject("modelList", workExperienceToModel(list));
		}
		return mav;
	}
	
	private List<WorkExperienceModel> workExperienceToModel(List<WorkExperience> list) {
		List<WorkExperienceModel> modelList = new ArrayList<WorkExperienceModel>();
		if (list != null && list.size() > 0) {
			
			for (int i = 0; i < list.size(); i++) {
				WorkExperience ee = list.get(i);
				WorkExperienceModel model = new WorkExperienceModel();
				String startDate = MyStrings.dateStringToString(ee.getStartDate());
				model.setStartDate(startDate);
				model.setEndDate(MyStrings.dateStringToString(ee.getEndDate()));
				model.setDetails(ee.getDetails());
				modelList.add(model);
			}
			
		}
		return modelList;
	}
	
	@RequestMapping(value="/saveWE", method = RequestMethod.POST)
	public @ResponseBody String postWorkExperiences(@RequestBody List<WorkExperienceModel> modelList) {
		User user = authenticationFacade.getLoginUser();
		int personId = user.getId();
		workExperienceService.saveWorkExperiences(personId, modelToWorkExperience(personId, modelList));
		return "success";
	}
	
	private List<WorkExperience> modelToWorkExperience(int personId, List<WorkExperienceModel> modelList) {
		List<WorkExperience> list = new ArrayList<WorkExperience>();
		if (modelList != null && modelList.size() > 0) {
			
			for (int i = 0; i < modelList.size(); i++) {
				WorkExperienceModel model = modelList.get(i);
				WorkExperience we = new WorkExperience();
				we.setPersonId(personId);
				if (model.getStartDate() != null && !model.getStartDate().isEmpty()) {
					we.setStartDate(model.getStartDate().concat("01"));
				}
				if (model.getEndDate() != null && !model.getEndDate().isEmpty()) {
					we.setEndDate(model.getEndDate().concat("01"));
				}				
				we.setDetails(model.getDetails());
				list.add(we);
			}
			
		}
		return list;
	}
}
