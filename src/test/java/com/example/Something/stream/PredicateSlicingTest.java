package com.example.Something.stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.*;

import com.example.Something.stream.Dish.Type;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class PredicateSlicingTest {

	public List<Dish> getMenuCaloriesAsc() {
		List<Dish> menu = Arrays.asList(
				new Dish("seasonal fruit", true, 120, Type.OTHER),
				new Dish("prawns", false, 300, Type.FISH),
				new Dish("rice", true, 350, Type.OTHER),
				new Dish("chicken", false, 400, Type.MEAT)
		);

		return menu;
	}

	@Test
	void 정렬된_메뉴에서_칼로리_320_미만의_요리를_선택() {
		// given
		List<Dish> menu = getMenuCaloriesAsc();

		// when
		final List<String> sliceMenu = menu.stream()
				.takeWhile(dish -> dish.getCalories() < 320)
				.map(Dish::getName)
				.collect(toList());

		// then
		assertThat(sliceMenu).containsExactly("seasonal fruit", "prawns");
	}

	@Test
	void 정렬된_메뉴에서_칼로리_320_이상의_요리를_선택() {
		// given
		List<Dish> menu = getMenuCaloriesAsc();

		// when
		final List<String> sliceMenu = menu.stream()
				.dropWhile(dish -> dish.getCalories() < 320)
				.map(Dish::getName)
				.collect(toList());

		// then
		assertThat(sliceMenu).containsExactly("rice", "chicken");
	}

}
