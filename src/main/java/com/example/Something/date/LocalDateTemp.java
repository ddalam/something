package com.example.Something.date;

import java.time.LocalDate;
import java.time.Period;

public class LocalDateTemp {

	LocalDate start = LocalDate.of(2021, 11, 15);
	LocalDate end = LocalDate.of(2022, 1, 10);

	Period period = Period.between(start, end);
	int days = period.getDays();

	void add() {

		LocalDate newLocalDate = start;

		while(!newLocalDate.isAfter(end)) {
			System.out.println("처리할 날짜");
			System.out.println(newLocalDate);

			newLocalDate = newLocalDate.plusDays(1);
		}
	}
}
