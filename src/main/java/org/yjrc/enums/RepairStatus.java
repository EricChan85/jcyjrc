package org.yjrc.enums;

public enum RepairStatus {
	/*GREEN, YELLOW, RED  */
	COMMITED, REPAIRED, EVALUATED;
	
	public int getValue() {
		return ordinal() + 1;
	}
}
