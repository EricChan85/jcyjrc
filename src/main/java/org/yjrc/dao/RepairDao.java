package org.yjrc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.yjrc.domain.Repair;

public interface RepairDao {

	void insertRepair(Repair repair);
	
	List<Repair> getByPersonId(int personId);
	
	Integer getCountByStatus(@Param("status")int status);
	
	List<Repair> getByStatus(@Param("status")int status, 
			@Param("offset")int offset, @Param("count")int count);
	
	Repair getById(int id);
	
	void updateRepairDescription(Repair repair);
	
	void updateEvaluation(Repair repair);
}
