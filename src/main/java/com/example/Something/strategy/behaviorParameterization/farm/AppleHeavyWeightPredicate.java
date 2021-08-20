/**
    다양한 선택 조건을 대표하는 여러 ApplePredicate를 정의할 수 있다

    "무게가 150그램 이상인 사과인지?"
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {

    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }

}