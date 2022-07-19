package com.example.Something.stream;

import static org.assertj.core.api.Assertions.*;

import com.example.Something.stream.Dish.Type;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class MatchingTest {

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
	void anyMatch() {
	  // given
		List<Dish> menu = getMenu();

	  // when
	  boolean isExistVegetarian = menu.stream()
			  .anyMatch(Dish::isVegetarian);

	  // then
		assertThat(isExistVegetarian).isTrue();
	}

	@Test
	void allMatch() {
	  // given
		List<Dish> menu = getMenu();

	  // when
		boolean isHealthy = menu.stream()
				.allMatch(dish -> dish.getCalories() < 1000);

	  // then
	  assertThat(isHealthy).isTrue();
	}

	@Test
	void noneMatch() {
	  // given
		List<Dish> menu = getMenu();

	  // when
	  boolean isHealthy = menu.stream()
			  .noneMatch(dish -> dish.getCalories() >= 1000);

	  // then
		assertThat(isHealthy).isTrue();
	}
}
