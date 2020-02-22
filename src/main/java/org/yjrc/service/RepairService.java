package org.yjrc.service;

import java.util.List;

import org.yjrc.domain.Repair;
import org.yjrc.models.RepairModel;

public interface RepairService {
	
	List<Repair> getByPersonId(int personId);
		
}
