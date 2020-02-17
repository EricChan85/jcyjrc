package org.yjrc.utils;

public class MyStrings {

	/*
	 * convert date String from db to yyyy.mm
	 * 1990-02-02 ---->  1990.02 
	 */
	public static String dateStringToString(String dateFromDb) {
		String dateString = "";
		if (dateFromDb != null && dateFromDb.length() > 0) {
			dateString = dateFromDb.substring(0, 7).replace('-', '.');
		}
	
		return dateString;
	}
}
