package org.yjrc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.yjrc.dao.WorkExperienceDao;
import org.yjrc.domain.WorkExperience;

public class WorkExperienceServiceImpl implements WorkExperienceService {

	@Autowired
	private WorkExperienceDao workExperienceDao;
	
	@Override
	public List<WorkExperience> getWorkExperiencesByPersonId(int personId) {		
		return workExperienceDao.getWorkExperiencesByPersonId(personId);
	}

	@Override
	@Transactional
	public void saveWorkExperiences(int personId, List<WorkExperience> list) {
		workExperienceDao.deleteWorkExperiencesByPersonId(personId);
		for (int i = 0; i < list.size(); i++) {
			workExperienceDao.insertWorkExperience(list.get(i));
		}
		
	}

}
