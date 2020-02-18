package org.yjrc.service;

import java.util.List;
import org.yjrc.domain.WorkExperience;

public interface WorkExperienceService {

	List<WorkExperience> getWorkExperiencesByPersonId(int personId);
	
	void saveWorkExperiences(int personId, List<WorkExperience> list);
}
