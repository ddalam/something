package com.example.Something.innerClass;

public class Out {

	private int num = 10;
	private static int sNum = 20;

	// 보통 외부 클래스에 내부 클래스 타입의 변수를 선언한 뒤
	// 생성자에서 in = new In(); 으로 내부 클래스를 생성해준다
	private In in;

	public Out() {
		in = new In();
	}

	// 인스턴스 내부 클래스
	// 외부 클래스에서만 사용할거라면 private으로 선언을 많이한다
	private class In {
		int inNum = 100;

		// static int sInNum = 500; -> 오류가 발생한다
		// 왜냐하면 인스턴스 내부 클래스는 외부 클래스가 먼저 생성된 후에 생성된다
		// 하지만 static 변수는 외부 클래스와 상관없이 사용하겠다는 의미이기 때문에 오류가 발생한다
		// static 내부 클래스에서는 static 변수를 사용할 수 있다

		void inTest() {
			// 내부 클래스에서 외부 클래스의 private 변수를 사용할 수 있다
			System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");

			// static 변수는 인스턴스 보다 먼저 생성되기 때문에 사용할 수 있다
			System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");

			System.out.println("InClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수)");
		}
	}

	// private 아닌 인스턴스 내부 클래스
	// 외부 클래스가 아닌 다른 외부에서도 생성할 수 있다 -> but, 이렇게 쓰는 일의 거의 없다
	// 외부 클래스를 사용해서 이 내부 클래스를 생성한다
	// new Out.In2() 이런 생성자는 없고 이미 만들어진 Out 클래스를 사용해서 생성해야 한다
	class In2 {
		int inNum = 100;

		void inTest() {
			System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
			System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
			System.out.println("InClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수)");
		}
	}

	public void usingInClass() {
		// 외부 클래스 메서드에서 내부 클래스의 메서드를 사용
		in.inTest();
	}
}