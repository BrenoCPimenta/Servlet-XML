package br.com.Java.domain;

import java.sql.Date;
import java.util.Calendar;

public class SimpleDate {

	private Calendar cal = Calendar.getInstance();
	
	public SimpleDate(int year, int month, int day) {
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
