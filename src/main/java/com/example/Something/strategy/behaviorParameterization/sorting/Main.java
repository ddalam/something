/**
    Java 8의 List에는 sort 메서드가 포함되어 있다.
    java.util.Comparator 객체를 이용해서 sort의 동작을 파라미터화 할 수 있다
 */
public class Main{

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        // 익명 클래스를 이용해서 무게가 적은 순서로 사과를 정렬
        // 요구사항이 바뀌면 새로운 요구사항에 맞는 Comparator를 만들어 sort 메서드에 전달할 수 있다.
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        })

        // or
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        };

        // 람다 표현식을 사용하면
        inventory.sort(
            (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())
        );

        // or
        Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    }
}