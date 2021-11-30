package com.example.Something.effectiveJava.item2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NutritionFactsTest {

	@Test
	void createInstance() {
		NutritionFacts nutritionFacts = new NutritionFacts.Builder(4, 5).build();

		assertEquals(nutritionFacts.getServingSize(), 4);
		assertEquals(nutritionFacts.getServings(), 5);
		assertEquals(nutritionFacts.getCalories(), 0);
	}
}