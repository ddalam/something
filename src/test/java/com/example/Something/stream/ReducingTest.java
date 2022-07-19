package com.example.Something.stream;

import static org.assertj.core.api.Assertions.*;

import com.example.Something.stream.Dish.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ReducingTest {

	@Test
	void sum() {
	  // given
		List<Integer> numbers = Arrays.asList(4, 5, 3, 9);

	  // when
		Integer sum = numbers.stream()
				.reduce(0, Integer::sum);

		// then
		assertThat(sum).isEqualTo(21);
	}

	@Test
	void sumNoneInitValue() {
		// given
		List<Integer> numbers = Arrays.asList(4, 5, 3, 9);

		// when
		Optional<Integer> sum = numbers.stream()
				.reduce(Integer::sum);

		// then
		assertThat(sum).hasValue(21);
	}

	@Test
	void getMax() {
	  // given
		List<Integer> numbers = Arrays.asList(4, 5, 3, 9);

	  // when
		Optional<Integer> max = numbers.stream()
				.reduce(Integer::max);

		// then
		assertThat(max).hasValue(9);
	}

	@Test
	void getMin() {
	  // given
		List<Integer> numbers = Arrays.asList(4, 5, 3, 9);

	  // when
		Optional<Integer> min = numbers.stream()
				.reduce(Integer::min);

		// then
		assertThat(min).hasValue(3);
	}

	@Test
	void getCount() {
	  // given
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

	  // when
		Optional<Integer> count = menu.stream()
				.map(dish -> 1)
				.reduce(Integer::sum);

		// then
		assertThat(count).hasValue(9);
	}
}
