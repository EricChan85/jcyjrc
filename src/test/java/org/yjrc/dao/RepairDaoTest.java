package org.yjrc.dao;


import static org.junit.Assert.assertEquals;

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
		domain.setStatus(1);
		this.repairDao.insertRepair(domain);
	}
	
	@Test
	public void getByPersonIdTest() {
		List<Repair> list = this.repairDao.getByPersonId(2);
		Assert.isTrue(list.size() > 0);
	}
	
	@Test
	public void getCountByStatusTest() {
		Integer count = this.repairDao.getCountByStatus(1);
		Assert.isTrue(count != null && count > 0);
	}
	
	@Test
	public void getByStatusTest() {
		List<Repair> list = this.repairDao.getByStatus(1, 0, 10);
		Assert.isTrue(list.size() > 0);
	}

	@Test
	public void getByIdTest() {
		Repair repair = this.repairDao.getById(1);
		Assert.notNull(repair);
	}
	
	@Test
	public void updateRepairDescriptionTest() {
		Repair repair = this.repairDao.getById(1);
		String description = "good";
		int status = 2;
		int repairmanId = 75;
		Date repairTime = new Date();
		repair.setRepairDescription(description);
		repair.setStatus(status);
		repair.setRepairmanId(repairmanId);
		repair.setRepairTime(repairTime);
		this.repairDao.updateRepairDescription(repair);
		repair = this.repairDao.getById(1);
		assertEquals(repair.getRepairDescription(), description);
		assertEquals(repair.getStatus(), status);
		assertEquals(repair.getRepairmanId(), repairmanId);
		/*assertEquals(repair.getRepairTime(), repairTime);*/
	}
	
	@Test
	public void updateEvaluationTest() {
		Repair repair = this.repairDao.getById(1);
		String evaluation = "good";
		int status = 3;		
		Date evaluationTime = new Date();
		repair.setEvaluation(evaluation);
		repair.setStatus(status);		
		repair.setEvaluationTime(evaluationTime);
		this.repairDao.updateEvaluation(repair);
		repair = this.repairDao.getById(1);
		assertEquals(repair.getEvaluation(), evaluation);
		assertEquals(repair.getStatus(), status);
	}
}
