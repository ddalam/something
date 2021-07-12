/**
 * 코드 출처
 * 1. Guide to JUnit 5 Parameterized Tests
 * https://www.baeldung.com/parameterized-tests-junit-5
 */

package com.example.Something.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Practice_Parameterized {

	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
	void isOdd_test(int number) {
		assertThat(Numbers.isOdd(number)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "    "})
	void isBlank_test(String s) {
		assertThat(Strings.isBlank(s)).isTrue();
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"  ", "\t", "\n"})
	void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(String input) {
		System.out.println(input);
		assertTrue(Strings.isBlank(input));
	}
}
