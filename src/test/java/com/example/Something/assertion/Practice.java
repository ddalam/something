package com.example.Something.assertion;

import org.junit.jupiter.api.Test;

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
        assertThat("".isEmpty()).isTrue();
    }
}
