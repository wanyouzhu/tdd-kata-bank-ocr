package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UnitTest {
    @Test
    void should_equality_compare_to_others_correctly() {
        assertThat(new Unit(Digits.TWO)).isEqualTo(new Unit(Digits.TWO));
    }

    @Test
    void should_recognize_zero_correctly() {
        assertThat(new Unit(Digits.ZERO).result()).isEqualTo("0");
    }

    @Test
    void should_recognize_one_correctly() {
        assertThat(new Unit(Digits.ONE).result()).isEqualTo("1");
    }

    @Test
    void should_recognize_two_correctly() {
        assertThat(new Unit(Digits.TWO).result()).isEqualTo("2");
    }

    @Test
    void should_recognize_three_correctly() {
        assertThat(new Unit(Digits.THREE).result()).isEqualTo("3");
    }

    @Test
    void should_recognize_four_correctly() {
        assertThat(new Unit(Digits.FOUR).result()).isEqualTo("4");
    }

    @Test
    void should_recognize_five_correctly() {
        assertThat(new Unit(Digits.FIVE).result()).isEqualTo("5");
    }

    @Test
    void should_recognize_six_correctly() {
        assertThat(new Unit(Digits.SIX).result()).isEqualTo("6");
    }

    @Test
    void should_recognize_seven_correctly() {
        assertThat(new Unit(Digits.SEVEN).result()).isEqualTo("7");
    }

    @Test
    void should_recognize_eight_correctly() {
        assertThat(new Unit(Digits.EIGHT).result()).isEqualTo("8");
    }

    @Test
    void should_recognize_nine_correctly() {
        assertThat(new Unit(Digits.NINE).result()).isEqualTo("9");
    }

    @Test
    void should_throw_malformed_unit_exception_while_content_is_malformed() {
        assertThatThrownBy(() -> new Unit(singletonList("invalid-unit"))).isInstanceOf(MalformedUnitException.class);
    }
}
