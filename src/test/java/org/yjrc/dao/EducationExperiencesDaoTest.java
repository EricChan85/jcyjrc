package org.yjrc.dao;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.yjrc.domain.EducationExperiences;

@ContextConfiguration({"classpath:/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EducationExperiencesDaoTest {

	@Autowired
	private EducationExperiencesDao educationExperiencesDao;
	
	@Test
	public void insertEducationExperiencesTest() {
		EducationExperiences ee = new EducationExperiences();
		ee.setPersonId(2);
		ee.setStartDate("2019.01.01");
		ee.setEndDate("2020.01.01");
		ee.setDetails("在北京大学学习");
		educationExperiencesDao.insertEducationExperiences(ee);
		/*Assert.isTrue(1 == 1);*/
	}
	
	@Test
	public void getEducationExperiencesByPersonIdTest() {
		List<EducationExperiences> list = educationExperiencesDao.getEducationExperiencesByPersonId(2);
		Assert.isTrue(list.size() > 0);
	}

}
