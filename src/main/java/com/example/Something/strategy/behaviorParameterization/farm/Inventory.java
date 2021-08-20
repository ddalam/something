/**
    농장 재고
 */
public class Inventory {
    
    /**
        Apple 리스트 컬렉션을 반복하는 로직과 컬렉션의 각 요소에 적용한 동작(ApplePredicate)을 분리
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {     // 프레디케이트 객체로 사과 검사 조건을 캡슐화
                result.add(apple);
            }
        }

        return result;
    }

    /**
        리스트 추상화 
        Apple, Banana, 정수, 문자열 등에 사용할 수 있다
     */
     public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T e : list) {
            if(p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}