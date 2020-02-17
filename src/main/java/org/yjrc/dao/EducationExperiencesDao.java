package org.yjrc.dao;

import java.util.List;

import org.yjrc.domain.EducationExperiences;

public interface EducationExperiencesDao {

	/*
	 * 获取人才教育经历
	 */
	List<EducationExperiences> getEducationExperiencesByPersonId(int personId);
	
	/*
	 * 删除人才教育经历
	 */
	void deleteEducationExperiencesByPersonId(int personId);
	
	
	void insertEducationExperiences(EducationExperiences educationExperiences);
}
