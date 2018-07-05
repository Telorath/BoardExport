package service;

import java.text.ParseException;
import java.util.Date;

public interface DateService {
	
	Date getNow();
	
	Date getToday();

	Date getYesterday();

	Date getLastWeek();
	
	Date parseDate(String dateString) throws ParseException;

}
