package com.example.Something.string;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ApacheStringUtilsTest {

	@Test
	void leftPad() {
	  // given
		String s = "A";
		int size = 5;
		char padChar = '0';

	  // when
		String newString = StringUtils.leftPad(s, size, padChar);

	  // then
		Assertions.assertThat(newString).isEqualTo("0000A");
	}
}
