/**
    다양한 선택 조건을 대표하는 여러 ApplePredicate를 정의할 수 있다

    "150그램이 넘는 빨간 사과"
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate {

    public boolean test(Apple apple) {
        return RED.equals(apple.getColor()) && apple.getWeight() > 150;
    }

}