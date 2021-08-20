public class Main() {
    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();

        // 재고목록(inventory)에 값이 채워져 있다고 가정

        // 방법1. 정의된 클래스 사용하기 - 빨갛고, 무게가 150그램 보다 큰 사과들
        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());

        // 방법1. 정의된 클래스 사용하기 - 녹색 사과들
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());

        // 방법2. 익명 클래스 사용하기 - 무게가 150그램 보다 큰 사과들
        List<Apple> heavyApples = filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple a) {
                return a.getWeight() > 150;
            }
        });

        // 방법3. 람다 표현식 사용하기 - 빨간 사과들
        List<Apple> redApples = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));


        // 리스트가 추상화된 filter 메서드 사용하기
        List<Integer> numbers = new ArrayList<>();
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);

        
    }
}