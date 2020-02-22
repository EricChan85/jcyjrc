package org.yjrc.dao;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.yjrc.domain.Repair;

@ContextConfiguration({"classpath:/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RepairDaoTest {

	@Autowired
	private RepairDao repairDao;
	
	@Test
	public void insertRepairTest() {
		Repair domain = new Repair();
		domain.setPersonId(2);
		domain.setAddress("广厦花园5号楼5单元505");
		domain.setPhone("13689451185");
		domain.setDetails("0935jc420559欠费，麻烦处理一下");
		Date date = new Date();		
		domain.setStartTime(date);
		domain.setEndTime(date);
		domain.setCreateTime(date);
		this.repairDao.insertRepair(domain);
	}
	
	@Test
	public void getByPersonIdTest() {
		List<Repair> list = this.repairDao.getByPersonId(2);
		Assert.isTrue(list.size() > 0);
	}

}
