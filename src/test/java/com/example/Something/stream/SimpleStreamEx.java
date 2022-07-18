package com.example.Something.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleStreamEx {

	@Test
	void 스트림은_한_번만_소비할_수_있다() {
	  // given
		List<String> title = Arrays.asList("Java8", "In", "Action");
		Stream<String> s = title.stream();

	  // when
		s.forEach(System.out::println);

	  // then
		Assertions.assertThatThrownBy(() -> {
			s.forEach(System.out::println);
		}).isInstanceOf(IllegalStateException.class);
	}
}
