package org.yjrc.enums;

import java.util.HashMap;
import java.util.Map;

public enum RoleType {
	ADMIN("ROLE_ADMIN", "管理员"), 
	USER("ROLE_USER", "用户"), 
	STAFF("ROLE_STAFF", "公寓维修");		
	
	private String dbName;
	
	private String name;
	
	private static Map<String, String> roleMap = new HashMap<String, String>();
	
	private RoleType(String dbName, String name) {
		this.dbName = dbName;
		this.name = name;
	}	
	
	public static Map<String, String> getMap() {
		if (roleMap.isEmpty()) {
			roleMap.put(USER.dbName, USER.name);
			roleMap.put(STAFF.dbName, STAFF.name);
		}
		
		return roleMap;
	}
}
