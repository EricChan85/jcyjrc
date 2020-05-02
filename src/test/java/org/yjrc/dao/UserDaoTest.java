package org.yjrc.dao;


import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yjrc.domain.User;

@ContextConfiguration({"classpath:/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testGetUserByUserName() {
		User user = userDao.getUserByUserName("xiaoming");
		Assert.assertNotNull(user);
		System.out.println(user.getUserName());
	}
	
	@Test
	public void getByIdTest() {
		User user = userDao.getById(1);
		assertNotNull(user);
	}

}
