package org.yjrc.dao;

import java.util.List;

import org.yjrc.domain.Repair;

public interface RepairDao {

	void insertRepair(Repair repair);
	
	List<Repair> getByPersonId(int personId);
}
