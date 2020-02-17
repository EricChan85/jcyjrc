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
	 * 获取所有名族项
	 */
	Map<Integer, String> getAllNationalityItems();
	
	/*
	 * 获取政治面貌项
	 */
	Map<Integer, String> getAllPoliticalStatusItems();
}
