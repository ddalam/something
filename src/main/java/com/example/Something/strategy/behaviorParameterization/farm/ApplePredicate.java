/**
    참 또는 거짓을 반환하는 함수를 프레디케이트라고 한다

    사과 선택 전략을 캡슐화
 */
public interface ApplePredicate {
    boolean test (Apple apple);
}