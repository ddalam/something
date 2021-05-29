/**
 * 코드 출처 : Introduction to AssertJ
 * https://www.baeldung.com/introduction-to-assertj
 */

package com.example.Something.assertion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Assertion은 아래 import문을 통해
import static org.assertj.core.api.Assertions.*;

public class Practice {

    @Test
    void test() {
        // 어떤 것도 검증하지 않으며, 테스트에 실패하지 않는다
        assertThat("aa");
    }

    @Test
    void compareObjects() {
        Dog fido = new Dog("Fido", 5.25F);
        Dog fidosClone = new Dog("Fido", 5.25F);

        // isEqualTo()는 객체의 참조를 비교하기 때문에 실패
        assertThat(fido).isEqualTo(fidosClone);

        // 콘텐츠의 동등성을 비교하려면 isEqualToComparingFieldByFieldRecursively()를 사용
        assertThat(fido).isEqualToComparingFieldByFieldRecursively(fidosClone);
    }

    @Test
    void assertBoolean() {
        // Boolean에 대한 테스트는 isTrue(), isFalse()를 사용할 수 있다
        assertThat("".isEmpty()).isTrue();
    }

    @Test
    void assertIterableOrArray() {
        // 요소가 포함되어 있는지
        List<String> list = Arrays.asList("1", "2", "3");
        assertThat(list).contains("1");
        // 여러개의 element가 포함되어 있는지도 가능
        assertThat(list).contains("1", "3");

        // 비어있는지
        assertThat(list).isNotEmpty();

        // 주어진 문자로 시작되는지
        assertThat(list).startsWith("1");

        // 하나의 객체에 둘 이상의 assertion을 연결할 수 있다
        assertThat(list)
                .isNotEmpty()
                .contains("1")
                .doesNotContainNull()
                .containsSequence("2", "3"); // 실제 그룹이 시퀀스 값 사이에 추가 값없이 순서대로 지정된 시퀀스를 포함하는지 확인
    }

    @Test
    void assertCharacter() {
        char someCharacter = 'c';

        // someCharacter가 a가 아니고, 유니코드 테이블에 있는지, b보다 크고, 소문자인지 확인
        assertThat(someCharacter)
                .isNotEqualTo('a')
                .inUnicode()
                .isGreaterThanOrEqualTo('b')
                .isLowerCase();
    }
}
