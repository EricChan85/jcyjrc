package org.yjrc.enums;

public enum ActivityStatus {

	PUBLISHED, UNPUBLISHED;
	
	public int getValue() {
		return ordinal() + 1;
	}
}
