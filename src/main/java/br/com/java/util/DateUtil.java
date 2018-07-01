package br.com.java.util;

import java.sql.Date;
import java.util.Calendar;

public class DateUtil {

	private Calendar cal = Calendar.getInstance();
	
	public DateUtil(int year, int month, int day) {
		cal.set(Calendar.YEAR, year);
		//Needs to be -1, beacause it counts 0-11 months 
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
	}
	
	public Date getDate() {
		Date dateRepresentation = new Date(cal.getTimeInMillis());
		return dateRepresentation;
	}
}
