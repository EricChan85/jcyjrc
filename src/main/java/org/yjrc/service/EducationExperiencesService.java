package org.yjrc.service;

import java.util.List;

import org.yjrc.domain.EducationExperiences;

public interface EducationExperiencesService {

	/*
	 * 获取人才教育经历
	 */
	List<EducationExperiences> getEducationExperiencesByPersonId(int personId);
	
	void saveEducationExperiences(int personId, List<EducationExperiences> list);
}
