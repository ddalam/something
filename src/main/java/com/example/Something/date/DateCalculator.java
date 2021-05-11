package com.example.Something.date;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DateCalculator {

	public long between() {

		LocalDateTime date1 = LocalDateTime.of(2021, Month.MAY, 11, 10, 20, 0);
		LocalDateTime date2 = LocalDateTime.of(2021, Month.MAY, 21, 23, 59, 59);

		return ChronoUnit.DAYS.between(LocalDateTime.now(), date2);
	}
}
