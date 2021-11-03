package com.example.Something.innerClass;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutTest {

	@Test
	void privateInstanceInnerClassTest() {
		Out out = new Out();
		out.usingInClass();
	}

	@Test
	void defaultInstanceInnerClassTest() {
		Out out = new Out();
		Out.DefaultInstanceInner defaultInstanceInner = out.new DefaultInstanceInner();
		defaultInstanceInner.defaultInstanceInnerTest();
	}

	@Test
	void staticInnerClassTest() {
		Out.StaticInner staticInner = new Out.StaticInner();
		staticInner.staticInnerTest();

		Out.StaticInner.staticInnerStaticMethodTest();
	}

}