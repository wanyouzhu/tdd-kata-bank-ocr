package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EntryTest {
    @Test
    void should_equal_to_others_with_same_content() {
        assertThat(new Entry(entryContentOne())).isEqualTo(new Entry(entryContentOne()));
    }

    @Test
    void should_not_equal_to_others_with_different_contents() {
        assertThat(new Entry(entryContentOne())).isNotEqualTo(new Entry(entryContentTwo()));
    }

    @Test
    void should_resolve_content_correctly() {
        assertThat(new Entry(entryContentOne()).resolve()).isEqualTo("123456789");
    }

    private List<String> entryContentOne() {
        return Arrays.asList(
            "    _  _     _  _  _  _  _ ",
            "  | _| _||_||_ |_   ||_||_|",
            "  ||_  _|  | _||_|  ||_| _|",
            "                           "
        );
    }

    private List<String> entryContentTwo() {
        return Arrays.asList(
            " _  _  _  _  _  _        _ ",
            "|_ |_| _||_   ||_ |_|  ||_|",
            "|_| _| _| _|  ||_|  |  ||_|",
            "                           "
        );
    }
}