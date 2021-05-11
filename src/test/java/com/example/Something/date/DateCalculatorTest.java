package com.example.Something.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class DateCalculatorTest {

	@Test
	void testDaysBetween() {
		DateCalculator dateCalculator = new DateCalculator();

		assertEquals(dateCalculator.between(), 10L);
	}

	@Test
	void testIsAfter() {
		LocalDateTime date = LocalDateTime.of(2021, Month.MAY, 11, 23, 59, 59);

		System.out.println(date);
		System.out.println(LocalDateTime.now());

		assertEquals(true, date.isAfter(LocalDateTime.now()));
	}
}