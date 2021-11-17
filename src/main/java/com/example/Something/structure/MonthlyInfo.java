package com.example.Something.structure;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MonthlyInfo extends Info {

	private int month;

	@Builder
	public MonthlyInfo(final int year, final int month) {
		super(year);
		this.month = month;
	}

	@Override
	public String toString() {
		return "MonthlyInfo{" +
				"year=" + super.getYear() +
				", month=" + month +
				'}';
	}
}
