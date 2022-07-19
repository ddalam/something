package com.example.Something.stream;

public class Transaction {

	private final Trader trader;
	private final int year;
	private final int value;

	public Transaction(final Trader trader, final int year, final int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return this.trader;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		return "{" + this.trader + ", " +
				"year: " + this.year + ", " +
				"value: " + this.value + "}";
	}
}
