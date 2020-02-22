package org.yjrc.utils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateUtils {

	public static SimpleDateFormat getDateFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		//China
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+:08:00"));
		return dateFormat;
	}
}
