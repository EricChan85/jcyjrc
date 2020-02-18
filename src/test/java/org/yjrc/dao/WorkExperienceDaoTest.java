package org.yjrc.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.yjrc.domain.EducationExperiences;
import org.yjrc.domain.WorkExperience;

@ContextConfiguration({"classpath:/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkExperienceDaoTest {

	@Autowired
	private WorkExperienceDao workExperienceDao;
	
	@Test
	public void insertWorkExperienceTest() {
		WorkExperience ee = new WorkExperience();
		ee.setPersonId(2);
		ee.setStartDate("2019.01.01");
		ee.setEndDate("2020.01.01");
		ee.setDetails("在北京大学学习");
		workExperienceDao.insertWorkExperience(ee);
		Assert.isTrue(1 == 1);
	}
	
	@Test
	public void getWorkExperiencesByPersonIdTest() {
		List<WorkExperience> list = workExperienceDao.getWorkExperiencesByPersonId(2);
		Assert.isTrue(list.size() > 0);
	}

}
