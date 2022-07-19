package com.example.Something.stream;

import static org.assertj.core.api.Assertions.*;

import com.example.Something.stream.Dish.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchTest {

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
	void findAny() {
	  // given
		List<Dish> menu = getMenu();

	  // when
		Optional<String> dish = menu.stream()
				.filter(Dish::isVegetarian)
				.findAny()
				.map(Dish::getName);

		// then
		assertThat(dish).hasValue("french fries");
	}

	@Test
	void findFirst() {
	  // given
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);

	  // when
		Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
				.map(n -> n * n)
				.filter(n -> n % 3 == 0)
				.findFirst();

		// then
		assertThat(firstSquareDivisibleByThree).hasValue(9);
	}
}
