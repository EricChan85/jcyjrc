package org.yjrc.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.yjrc.dao.EnumsDao;
import org.yjrc.domain.Enums;

public class EnumsServiceImpl implements EnumsService {

	//名族
	private static final String NATIONALITY_KEY = "nationality";
	
	//政治面貌
	private static final String POLITICAL_STATUS_KEY = "politicaStatus";
	
	@Autowired
	private EnumsDao enumsDao;
		
	
	@Override
	public List<Enums> getAllNationality() {
		return enumsDao.getEnumsByType(NATIONALITY_KEY);
	}

	@Override
	public List<String> getAllNationalityNames() {
		return enumsDao.getEnumsNameByType(NATIONALITY_KEY);
	}

	@Override
	public Map<Integer, String> getAllNationalityItems() {
		List<Enums> list = enumsDao.getEnumsByType(NATIONALITY_KEY);
		Map<Integer, String> nationalityItems = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < list.size(); i++) {
			Enums e = list.get(i);
			nationalityItems.put(e.getEnumValue(), e.getEnumName());
		}
		return nationalityItems;
	}

	@Override
	public Map<Integer, String> getAllPoliticalStatusItems() {
		List<Enums> list = enumsDao.getEnumsByType(POLITICAL_STATUS_KEY);
		Map<Integer, String> items = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < list.size(); i++) {
			Enums e = list.get(i);
			items.put(e.getEnumValue(), e.getEnumName());
		}
		return items;
	}
	
	

}
