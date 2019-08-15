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
        assertThat(new Unit(Digits.ZERO).recognize()).isEqualTo("0");
    }

    @Test
    void should_resolve_one_correctly() {
        assertThat(new Unit(Digits.ONE).recognize()).isEqualTo("1");
    }

    @Test
    void should_resolve_two_correctly() {
        assertThat(new Unit(Digits.TWO).recognize()).isEqualTo("2");
    }

    @Test
    void should_resolve_three_correctly() {
        assertThat(new Unit(Digits.THREE).recognize()).isEqualTo("3");
    }

    @Test
    void should_resolve_four_correctly() {
        assertThat(new Unit(Digits.FOUR).recognize()).isEqualTo("4");
    }

    @Test
    void should_resolve_five_correctly() {
        assertThat(new Unit(Digits.FIVE).recognize()).isEqualTo("5");
    }

    @Test
    void should_resolve_six_correctly() {
        assertThat(new Unit(Digits.SIX).recognize()).isEqualTo("6");
    }

    @Test
    void should_resolve_seven_correctly() {
        assertThat(new Unit(Digits.SEVEN).recognize()).isEqualTo("7");
    }

    @Test
    void should_resolve_eight_correctly() {
        assertThat(new Unit(Digits.EIGHT).recognize()).isEqualTo("8");
    }

    @Test
    void should_resolve_nine_correctly() {
        assertThat(new Unit(Digits.NINE).recognize()).isEqualTo("9");
    }
}
