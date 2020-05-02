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
	
	/*
	 * 检查字符串是否为空
	 */
	public static boolean isEmpty(String str) {
		if(str == null || str.isEmpty() || str.trim().isEmpty()) {
			return true;
		} 
		return false;
	}
	
	/*
	 * "验证只包含字母和数字"
	 */
	public static boolean containsOnlyCharacterAndNumber(String str) {
		String pattern = "^[a-zA-Z0-9_]+$";
		return str.matches(pattern);
	}
}
