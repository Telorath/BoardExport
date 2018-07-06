package service;

import java.util.Date;

import exceptions.DateParseException;

public interface DateService {
	
	Date getNow();
	
	Date getToday();

	Date getYesterday();

	Date getLastWeek();
	
	Date parseDate(String dateString) throws DateParseException;

}
