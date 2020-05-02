package org.yjrc.enums;

public enum RepairStatus {
	
	COMMITED, REPAIRED, EVALUATED;
	
	public int getValue() {
		return ordinal() + 1;
	}
}
