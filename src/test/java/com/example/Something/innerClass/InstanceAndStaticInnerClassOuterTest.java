package com.example.Something.innerClass;

import org.junit.jupiter.api.Test;

class InstanceAndStaticInnerClassOuterTest {

	@Test
	void privateInstanceInnerClassTest() {
		InstanceAndStaticInnerClassOuter instanceAndStaticInnerClassOuter = new InstanceAndStaticInnerClassOuter();
		instanceAndStaticInnerClassOuter.usingInClass();
	}

	@Test
	void defaultInstanceInnerClassTest() {
		InstanceAndStaticInnerClassOuter instanceAndStaticInnerClassOuter = new InstanceAndStaticInnerClassOuter();
		InstanceAndStaticInnerClassOuter.DefaultInstanceInner defaultInstanceInner = instanceAndStaticInnerClassOuter.new DefaultInstanceInner();
		defaultInstanceInner.defaultInstanceInnerTest();
	}

	@Test
	void staticInnerClassTest() {
		InstanceAndStaticInnerClassOuter.StaticInner staticInner = new InstanceAndStaticInnerClassOuter.StaticInner();
		staticInner.staticInnerTest();

		InstanceAndStaticInnerClassOuter.StaticInner.staticInnerStaticMethodTest();
	}

}