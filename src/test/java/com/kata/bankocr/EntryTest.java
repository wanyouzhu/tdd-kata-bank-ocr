package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EntryTest {
    @Test
    void should_equal_to_others_with_same_content() {
        List<String> content = Arrays.asList(
            "    _  _     _  _  _  _  _ ",
            "  | _| _||_||_ |_   ||_||_|",
            "  ||_  _|  | _||_|  ||_| _|",
            "                           "
        );
        assertThat(new Entry(content)).isEqualTo(new Entry(content));
    }
}