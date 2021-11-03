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
	void defaultInstanceInnerClassTest() {
		Out out = new Out();
		Out.DefaultInstanceInner defaultInstanceInner = out.new DefaultInstanceInner();
		defaultInstanceInner.defaultInstanceInnerTest();
	}

}