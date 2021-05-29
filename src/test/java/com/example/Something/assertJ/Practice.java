package com.example.Something.assertJ;

import org.junit.jupiter.api.Test;

// Assertion은 아래 import문을 통해
import static org.assertj.core.api.Assertions.*;

public class Practice {

    @Test
    void test() {
        // 어떤 것도 검증하지 않으며, 테스트에 실패하지 않는다
        assertThat("aa");
    }
}
