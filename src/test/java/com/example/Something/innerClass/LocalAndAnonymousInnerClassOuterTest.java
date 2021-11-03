package com.example.Something.innerClass;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocalAndAnonymousInnerClassOuterTest {

	@Test
	void localInnerClassTest() {
		LocalAndAnonymousInnerClassOuter outer = new LocalAndAnonymousInnerClassOuter();
		Runnable runnable = outer.getRunnable(100);

		runnable.run();
	}

}