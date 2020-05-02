package org.yjrc.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yjrc.domain.Person;
import org.yjrc.enums.RoleType;
import org.yjrc.models.PersonBasicModel;
import org.yjrc.models.PersonInfoModel;
import org.yjrc.models.PersonListModel;
import org.yjrc.service.EnumsService;
import org.yjrc.service.PersonService;
import org.yjrc.utils.ConstantsUtils;
import org.yjrc.utils.SSPWUtils;

@Controller
@RequestMapping(value="/admin/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private EnumsService enumsService;
	
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
	@Qualifier("personBasicModelValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
    
	@ModelAttribute("roleTypes")
	public Map<String, String> registerContact() {
	    return RoleType.getMap();
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public ModelAndView addPerson(@RequestParam(name="success", required = false) Integer success) {		
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("person", new PersonBasicModel());		
		if (success != null && success == 1) {
			mav.addObject("result", "保存成功！");
		}
		return mav;
	}
	
	@RequestMapping(value="/newPerson", method = RequestMethod.POST)
	public String postPersonBasic(@ModelAttribute("person") @Validated PersonBasicModel personBasic,
							BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "/admin/person/add";
		}
		Person person = new Person(); //modelMapper.map(personBasic, Person.class);
		BeanUtils.copyProperties(personBasic, person);
		person.setPassword(SSPWUtils.getEncodedInitialPassword());
		this.personService.createPerson(person);
		return "redirect:/admin/person/add?success=1";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView personList(@RequestParam(name="error", required = false) boolean error) {		
				
		ModelAndView mav = new ModelAndView();
		List<Person> list =  this.personService.getPersonByRole(1, 100).getElements();
		Map<Integer, String> nationalityItems = enumsService.getStatusItemsByKey(ConstantsUtils.getNationalityKey());
		Map<Integer, String> psItems = enumsService.getStatusItemsByKey(ConstantsUtils.getPoliticalStatusKey());
		/*convertToModel(list.get(0));*/
		List<PersonListModel> modelList = list.stream().map(t -> convertToModel(t, nationalityItems, psItems)).collect(Collectors.toList());
		mav.addObject("list", modelList);
		return mav;
	}
	
	private PersonListModel convertToModel(Person person,
			Map<Integer, String> nationalityItems,
			Map<Integer, String> psItems) {
		PersonListModel model = new PersonListModel();
		BeanUtils.copyProperties(person, model);
		model.setDateOfBirthFromEntity(person.getDateOfBirth());
		model.setDateOfEnteringFromEntity(person.getDateOfEntering());
		model.setGender(person.getGender());
		model.setNationality(person.getNationality(), nationalityItems);
		model.setPoliticalStatus(person.getPoliticalStatus(), psItems);
		return model;
	}
	
}
