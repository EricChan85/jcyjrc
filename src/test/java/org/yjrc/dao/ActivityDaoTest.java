package org.yjrc.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yjrc.domain.Activity;

@ContextConfiguration({"classpath:/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ActivityDaoTest {

	@Autowired
	private ActivityDao activityDao;
	
	@Test
	public void createActivityTest() {
		Activity activity = new Activity();
		activity.setTitle("qqq");
		activity.setSketch("qqq");
		activity.setDetail("qqq");
		activity.setCreateTime(new Date());
		
		this.activityDao.createActivity(activity);
		
		Activity inserted = this.activityDao.getById(1);
		
		assertEquals(activity.getSketch(), inserted.getSketch());
	}
	
	@Test
	public void updateActivityTest() {
		Activity activity = new Activity();
		activity.setId(3);
		activity.setStatus(1);
		this.activityDao.updateActivity(activity);
		Activity updated = this.activityDao.getById(1);
		assertEquals(updated.getStatus(), 1);
	}
	
	@Test 
	public void getPublishedTest() {
		int count = 3;
		List<Activity> list = this.activityDao.getPublished(1, count);
		assertEquals(list.size(), count);
	}
}
