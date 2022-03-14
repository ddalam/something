package com.example.Something.modernJava.part1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class InventoryServiceTest {

	@Test
	void filterApplesTest() {
		InventoryService inventoryService = new InventoryService();

		Apple apple1 = Apple.builder()
						.color(Color.GREEN)
						.weight(120d)
						.build();

		Apple apple2 = Apple.builder()
				.color(Color.RED)
				.weight(152d)
				.build();

		List<Apple> inventory = new ArrayList<>();
		inventory.add(apple1);
		inventory.add(apple2);

		List<Apple> result = inventoryService.filterApples(inventory, Apple::isGreenApple);
		assertEquals(1, result.size());
		assertEquals(120d, result.get(0).getWeight());

		List<Apple> result2 = inventoryService.filterApples(inventory, Apple::isHeavyApple);
		assertEquals(1, result2.size());
		assertEquals(152d, result2.get(0).getWeight());

	}

}