package com.example.Something.innerClass;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutTest {

	@Test
	void privateInClassTest() {
		Out out = new Out();
		out.usingInClass();
	}

	@Test
	void defaultInClassTest() {
		Out out = new Out();
		Out.In2 in = out.new In2();
		in.inTest();
	}

}