package service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CalendarDateService implements DateService {
	
	public static final Long ONE_SECOND = 1000L;
	
	public static final Long ONE_MINUTE = ONE_SECOND * 60;
	
	public static final Long ONE_HOUR = ONE_MINUTE * 60;
	
	public static final Long ONE_DAY = ONE_HOUR * 24;

	public static final Long ONE_WEEK = ONE_DAY * 7;
	
	public Instant getNowInstant()
	{
		return Instant.now();
	}
	
	@Override
	public Date getToday() {
		return Date.from(getNowInstant().truncatedTo(ChronoUnit.DAYS));
	}

	@Override
	public Date getYesterday() {
		Instant instant = getNowInstant().truncatedTo(ChronoUnit.DAYS);

		return Date.from(instant.minusMillis(ONE_DAY));
	}

	@Override
	public Date getLastWeek() {
		Instant instant = getNowInstant().truncatedTo(ChronoUnit.DAYS);

		return Date.from(instant.minusMillis(ONE_WEEK));
	}

	@Override
	public Date getNow() {
		return Date.from(getNowInstant());
	}

}
