package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CalendarDateService implements DateService {

	public static final Long ONE_SECOND = 1000L;

	public static final Long ONE_MINUTE = ONE_SECOND * 60;

	public static final Long ONE_HOUR = ONE_MINUTE * 60;

	public static final Long ONE_DAY = ONE_HOUR * 24;

	public static final Long ONE_WEEK = ONE_DAY * 7;

	public Instant getNowInstant() {
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

	private Date parseMMDDYYYY(String dateString) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.parse(dateString);
	}

	public Date parseDate(String dateString) throws ParseException {
		return parseMMDDYYYY(dateString);
	}

}
