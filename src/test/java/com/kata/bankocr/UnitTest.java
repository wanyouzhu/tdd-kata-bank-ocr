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
        assertThat(new Unit(Digits.ZERO).recognize()).isEqualTo("0");
    }

    @Test
    void should_recognize_one_correctly() {
        assertThat(new Unit(Digits.ONE).recognize()).isEqualTo("1");
    }

    @Test
    void should_recognize_two_correctly() {
        assertThat(new Unit(Digits.TWO).recognize()).isEqualTo("2");
    }

    @Test
    void should_recognize_three_correctly() {
        assertThat(new Unit(Digits.THREE).recognize()).isEqualTo("3");
    }

    @Test
    void should_recognize_four_correctly() {
        assertThat(new Unit(Digits.FOUR).recognize()).isEqualTo("4");
    }

    @Test
    void should_recognize_five_correctly() {
        assertThat(new Unit(Digits.FIVE).recognize()).isEqualTo("5");
    }

    @Test
    void should_recognize_six_correctly() {
        assertThat(new Unit(Digits.SIX).recognize()).isEqualTo("6");
    }

    @Test
    void should_recognize_seven_correctly() {
        assertThat(new Unit(Digits.SEVEN).recognize()).isEqualTo("7");
    }

    @Test
    void should_recognize_eight_correctly() {
        assertThat(new Unit(Digits.EIGHT).recognize()).isEqualTo("8");
    }

    @Test
    void should_recognize_nine_correctly() {
        assertThat(new Unit(Digits.NINE).recognize()).isEqualTo("9");
    }

    @Test
    void should_throw_malformed_unit_exception_while_content_is_malformed() {
        Unit unit = new Unit(singletonList("invalid-unit"));
        assertThatThrownBy(unit::recognize).isInstanceOf(MalformedUnitException.class);
    }
}
