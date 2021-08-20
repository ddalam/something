/**
    다양한 선택 조건을 대표하는 여러 ApplePredicate를 정의할 수 있다

    "녹색 사과인지?"
 */
public class AppleGreenColorPredicate implements ApplePredicate {

    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

}