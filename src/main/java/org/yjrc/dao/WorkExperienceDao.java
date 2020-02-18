package org.yjrc.dao;

import java.util.List;

import org.yjrc.domain.WorkExperience;

public interface WorkExperienceDao {

	/*
	 * 获取人才教育经历
	 */
	List<WorkExperience> getWorkExperiencesByPersonId(int personId);
	
	/*
	 * 删除人才教育经历
	 */
	void deleteWorkExperiencesByPersonId(int personId);
	
	
	void insertWorkExperience(WorkExperience WorkExperience);
}
