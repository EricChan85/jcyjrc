package org.yjrc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.yjrc.dao.RepairDao;
import org.yjrc.domain.Repair;

public class RepairServiceImpl implements RepairService {

	@Autowired
	private RepairDao repairDao;
	
	
	public List<Repair> getByPersonId(int personId) {
		
		return this.repairDao.getByPersonId(personId);
	}

}
