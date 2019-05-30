package com.learning.lizard.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	
	static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss" ;
	static final String DATE_FORMAT_MMDDYYYY = "MM-dd-yyyy" ;
	
	public static String getFormattedDateTime(Date timeStamp)
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
		System.out.println(sdf.format(timeStamp));
		return "";
	}
	
	public static String getFormattedDateMMDDYYYY(Date timeStamp)
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_MMDDYYYY);
		System.out.println(sdf.format(timeStamp));
		return "";
	}
	
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		getFormattedDateTime(date);
		getFormattedDateMMDDYYYY(date);
	}
	
	
}
