package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UnitTest {
    @Test
    void should_equality_compare_to_others_correctly() {
        assertThat(new Unit(two())).isEqualTo(new Unit(two()));
    }

    private List<String> two() {
        return Arrays.asList(
            " _ ",
            " _|",
            "|_ ",
            "   "
        );
    }
}
