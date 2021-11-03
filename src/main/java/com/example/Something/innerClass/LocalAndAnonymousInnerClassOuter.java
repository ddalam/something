package com.example.Something.innerClass;

public class LocalAndAnonymousInnerClassOuter {

	int outNum = 100;
	static int sNum = 200;

	// 메서드의 매개변수는 stack 메모리에 생성
	Runnable getRunnableUsingLocalInnerClass(int i) {

		// stack 메모리에 생성
		int num = 10;

		// getRunnable() 내부에 있는 지역 내부 클래스
		class MyRunnable implements Runnable {

			int localNum = 1000;

			@Override
			public void run() {

				// i = 50;
				// num = 20;
				/**
				 * 메서드의 지역변수(i, num)을 get하는건 가능하지만, set하는건 불가능하다
				 * set 하려고 하면 이런 메시지가 나온다 -> Variable 'i' is accessed from within inner class, needs to be final or effectively final
				 * 왜냐하면 getRunnable() 메서드의 지역변수 생명주기와 MyRunnable 클래스의 생명주기가 달라서 그렇다
				 * i와 num은 stack 메모리에 생성되었다가 메서드가 종료되면 메모리에서 제거된다
				 * but, MyRunnable 클래스는 생성되면 나중에 또 호출될 수 있다
				 * 또 호출되었을 때 i, num이 없으면 값을 할당해줄 수 없게 된다 -> 그럼 i, num은 stack에 생성되면 안된다 -> 그래서 이런 경우에 컴파일러가 다 final로 처리해버린다
				 * 따라서 내부 클래스에서 접근하는 변수들은 stack에 생성되고, 상수화돼서 상수 메모리에 생성된다 -> 그렇기 때문에 값을 변경할수는 없는 것이다
				 */

				System.out.println("i = " + i);
				System.out.println("num = " + num);
				System.out.println("localNum = " + localNum);

				// 지역 내부 클래스는 외부 클래스가 생성된 다음 불리기 때문에 외부 클래스 인스턴스 변수에 접근 가능
				System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
				System.out.println("LocalAndAnonymousInnerClassOuter.sNum = "
						+ LocalAndAnonymousInnerClassOuter.sNum + "(외부 클래스 정적 변수)");
			}
		}

		return new MyRunnable();
	}

	Runnable getRunnableUsingAnonymousInnerClass(int i) {

		int num = 10;

		// 익명 내부 클래스 : 클래스의 이름(MyRunnable 같은)을 쓸 일이 없기 때문에 클래스의 이름을 없애고 Runnable 인터페이스를 구현한 객체를 바로 리턴
		return new Runnable() {

			int localNum = 1000;

			// 여전히 i, num을 변경하는 것은 불가능

			@Override
			public void run() {
				System.out.println("i = " + i);
				System.out.println("num = " + num);
				System.out.println("localNum = " + localNum);

				// 지역 내부 클래스는 외부 클래스가 생성된 다음 불리기 때문에 외부 클래스 인스턴스 변수에 접근 가능
				System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
				System.out.println("LocalAndAnonymousInnerClassOuter.sNum = "
						+ LocalAndAnonymousInnerClassOuter.sNum + "(외부 클래스 정적 변수)");
			}
		};
	}

	// 이런 사용도 가능
	// 원래 Runnable을 구현한 어떤 클래스를 정의해야 하는데(내부 클래스) 이름 없이 정의했기 때문에 이것도 익명 내부 클래스
	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			System.out.println("Runnable class");
		}
	};
}
