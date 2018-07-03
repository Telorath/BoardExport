package service;

import java.util.Date;

public interface DateService {
	
	Date getNow();
	
	Date getToday();

	Date getYesterday();

	Date getLastWeek();

}
