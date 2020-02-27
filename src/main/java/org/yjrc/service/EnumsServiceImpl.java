package org.yjrc.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.yjrc.dao.EnumsDao;
import org.yjrc.domain.Enums;
import org.yjrc.utils.ConstantsUtils;

public class EnumsServiceImpl implements EnumsService {
	
	
	private final ConcurrentMap<String, Map<Integer, String>> cacheMap = new ConcurrentHashMap<>();
	
	@Autowired
	private EnumsDao enumsDao;
		
	
	@Override
	public List<Enums> getAllNationality() {
		return enumsDao.getEnumsByType(ConstantsUtils.getNationalityKey());
	}

	@Override
	public List<String> getAllNationalityNames() {
		return enumsDao.getEnumsNameByType(ConstantsUtils.getNationalityKey());
	}


	@Override
	public Map<Integer, String> getStatusItemsByKey(String key) {
		Map<Integer, String> pairs = cacheMap.get(key);
		if (pairs == null) {
			List<Enums> list = enumsDao.getEnumsByType(key);
			pairs = new LinkedHashMap<Integer, String>();
			for (int i = 0; i < list.size(); i++) {
				Enums e = list.get(i);
				pairs.put(e.getEnumValue(), e.getEnumName());
			}
			Map<Integer, String> old = cacheMap.putIfAbsent(key, pairs);
			if (old != null) {
				pairs = old;
			}
		}
		
		return pairs;
	}
	
	
	

}
