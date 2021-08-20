/**
    Runnable 인터페이스의 run 메서드의 동작을 파라미터화 할 수 있다
 */
public class Main() {

    public static void main(String[] args) {

        // Java 8까지는 Thread 생성자에 객체만 전달할 수 있었기 때문에 익명 클래스로 Runnable 인터페이스를 구현하도록 하는 것이 일반적인 방법이었다
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello world");
            }
        });

        // 람다 표현식을 사용하면
        Thread t2 = new Thread(() -> System.out.println("Hello world"));
    }

}