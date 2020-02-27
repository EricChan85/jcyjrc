package org.yjrc.service;

import java.util.List;
import java.util.Map;

import org.yjrc.domain.Enums;

public interface EnumsService {
	
	List<Enums> getAllNationality();
	
	/*
	 * 获取所有名族的名称
	 */
	List<String> getAllNationalityNames();

	
	/*
	 * 获取枚举keyValuePair
	 */
	Map<Integer, String> getStatusItemsByKey(String key);
}
