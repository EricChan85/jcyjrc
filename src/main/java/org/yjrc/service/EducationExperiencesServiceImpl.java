package org.yjrc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.yjrc.dao.EducationExperiencesDao;
import org.yjrc.domain.EducationExperiences;

public class EducationExperiencesServiceImpl implements  EducationExperiencesService{

	@Autowired
	private EducationExperiencesDao educationExperiencesDao;
	
	@Override
	public List<EducationExperiences> getEducationExperiencesByPersonId(int personId) {
		return educationExperiencesDao.getEducationExperiencesByPersonId(personId);
	}

	@Override
	public void saveEducationExperiences(int personId, List<EducationExperiences> list) {
		
		educationExperiencesDao.deleteEducationExperiencesByPersonId(personId);
		for (int i = 0; i < list.size(); i++) {
			educationExperiencesDao.insertEducationExperiences(list.get(i));
		}
		
	}


	
}
