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

    @Test
    void should_resolve_one_correctly() {
        assertThat(new Unit(Digits.ONE).resolve()).isEqualTo("1");
    }

    @Test
    void should_resolve_two_correctly() {
        assertThat(new Unit(Digits.TWO).resolve()).isEqualTo("2");
    }

    @Test
    void should_resolve_three_correctly() {
        assertThat(new Unit(Digits.THREE).resolve()).isEqualTo("3");
    }
}