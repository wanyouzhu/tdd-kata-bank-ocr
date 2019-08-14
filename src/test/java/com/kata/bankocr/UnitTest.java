package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UnitTest {
    @Test
    void should_equality_compare_to_others_correctly() {
        assertThat(new Unit(Digits.TWO)).isEqualTo(new Unit(Digits.TWO));
    }

    @Test
    void should_resolve_zero_correctly() {
        assertThat(new Unit(Digits.ZERO).resolve()).isEqualTo("0");
    }
}
