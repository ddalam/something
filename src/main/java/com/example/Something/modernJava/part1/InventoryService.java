package com.example.Something.modernJava.part1;

import static com.example.Something.modernJava.part1.Color.GREEN;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class InventoryService {

	public static boolean isGreenApple(Apple apple) {
		return GREEN.equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

	static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

}
