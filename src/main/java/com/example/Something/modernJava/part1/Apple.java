package com.example.Something.modernJava.part1;

import static com.example.Something.modernJava.part1.Color.GREEN;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Apple {

	private Color color;

	private Double weight;

	public static boolean isGreenApple(Apple apple) {
		return GREEN.equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

}
