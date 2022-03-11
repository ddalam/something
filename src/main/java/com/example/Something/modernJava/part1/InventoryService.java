package com.example.Something.modernJava.part1;

import static com.example.Something.modernJava.part1.Color.GREEN;

public class InventoryService {

	public static boolean isGreenApple(Apple apple) {
		return GREEN.equals(apple.getColor());
	}

}
