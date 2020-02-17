package org.yjrc.dao;

import java.util.List;

import org.yjrc.domain.Enums;

public interface EnumsDao {

	List<Enums> getEnumsByType(String type);
	
	List<String> getEnumsNameByType(String type);
}
