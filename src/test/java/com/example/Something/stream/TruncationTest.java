package com.example.Something.stream;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import com.example.Something.stream.Dish.Type;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TruncationTest {

	public List<Dish> getMenu() {
		List<Dish> menu = Arrays.asList(
				new Dish("port", false, 800, Type.MEAT),
				new Dish("beef", false, 700, Type.MEAT),
				new Dish("chicken", false, 400, Type.MEAT),
				new Dish("french fries", true, 530, Type.OTHER),
				new Dish("rice", true, 350, Type.OTHER),
				new Dish("seasonal fruit", true, 120, Type.OTHER),
				new Dish("pizza", true, 550, Type.OTHER),
				new Dish("prawns", false, 300, Type.FISH),
				new Dish("salmon", false, 450, Type.FISH)
		);

		return menu;
	}

	@Test
	void createNewStreamUsingLimit() {
	  // given
		List<Dish> menu = getMenu();

	  // when
		final List<String> collect = menu.stream()
				.filter(dish -> dish.getCalories() > 300)
				.limit(3)
				.map(Dish::getName)
				.collect(toList());

		// then
		assertThat(collect).containsExactly("port", "beef", "chicken");
	}

	@Test
	void createNewStreamUsingSkip() {
	  // given
		List<Dish> menu = getMenu();

	  // when
		final List<String> collect = menu.stream()
				.filter(dish -> dish.getCalories() > 300)
				.skip(2)
				.map(Dish::getName)
				.collect(toList());

		// then
		assertThat(collect).containsExactly("chicken", "french fries", "rice", "pizza", "salmon");
	}
	
	@Test
	void choiceTwoMeatDishesAppearFirstTime() {
	  // given
		List<Dish> menu = getMenu();
	  
	  // when
		final List<String> collect = menu.stream()
				.filter(dish -> dish.getType() == Type.MEAT)
				.limit(2)
				.map(Dish::getName)
				.collect(toList());

		// then
		assertThat(collect).containsExactly("port", "beef");
	}
}
