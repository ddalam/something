package com.example.Something.stream;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class MappingTest {

	@Test
	void getLengthListEachWord() {
	  // given
		final List<String> words = Arrays.asList("Modern", "Java", "In", "Action");

		// when
		final List<Integer> wordLengths = words.stream()
				.map(String::length)
				.collect(toList());

		// then
		assertThat(wordLengths).containsExactly(6, 4, 2, 6);
	}

	@Test
	void getUniqueCharactersList() {
	  // given
		final List<String> words = Arrays.asList("Hello", "World");

	  // when
		final List<String> collect = words.stream()
				.map(word -> word.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(toList());

		// then
		assertThat(collect).hasSize(7);
	}

	@Test
	void createListOfPairsOfNumbers() {
	  // given
		final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		final List<Integer> numbers2 = Arrays.asList(3, 4);

		// when
		final List<int[]> collect = numbers1.stream()
				.flatMap(i -> numbers2.stream()
						.map(j -> new int[]{i, j}))
				.collect(toList());

		// then
		assertThat(collect).hasSize(6);
	}

	@Test
	void createSumOfPairsOfNumbersMultipleOf3List() {
	  // given
		final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		final List<Integer> numbers2 = Arrays.asList(3, 4);

	  // when
		final List<int[]> collect = numbers1.stream()
				.flatMap(i -> numbers2.stream()
						.filter(j -> (i + j) % 3 == 0)
						.map(j -> new int[]{i, j})
				)
				.collect(toList());

	  // then
		assertThat(collect).hasSize(2);
	}
}
