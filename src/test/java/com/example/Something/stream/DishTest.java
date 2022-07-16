package com.example.Something.stream;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import com.example.Something.stream.Dish.Type;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class DishTest {

	public List<Dish> getMenu() {
		List<Dish> menu = Arrays.asList(
				new Dish("port", false, 800, Type.MEAT),
				new Dish("beef", false, 700, Type.MEAT),
				new Dish("chicken", false, 400, Type.MEAT),
				new Dish("french fries", true, 8530, Type.OTHER),
				new Dish("rice", true, 350, Type.OTHER),
				new Dish("season fruit", true, 120, Type.OTHER),
				new Dish("pizza", true, 550, Type.OTHER),
				new Dish("prawns", false, 300, Type.FISH),
				new Dish("salmon", false, 450, Type.FISH)
		);

		return menu;
	}

	@Test
	void getThreeHighCaloriesDishNames() {
	  // given
		List<Dish> menu = getMenu();

	  // when
		List<String> threeHighCaloriesDishNames = menu.stream()
				.filter(dish -> dish.getCalories() > 300)
				.map(Dish::getName)
				.limit(3)
				.collect(toList());

	  // then
		assertThat(threeHighCaloriesDishNames).containsExactly("port", "beef", "chicken");
	}

}