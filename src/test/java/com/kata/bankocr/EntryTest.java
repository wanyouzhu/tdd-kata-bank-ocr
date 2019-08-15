package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void should_throw_malformed_entry_exception_while_content_is_malformed() {
        assertThatThrownBy(() -> new Entry(malformedContent())).isInstanceOf(MalformedEntryException.class);
    }

    @Test
    void should_recognize_content_correctly() {
        assertThat(new Entry(entryContentOne()).result()).isEqualTo("123456789");
    }

    @Test
    void should_append_err_while_checksum_failed() {
        assertThat(new Entry(entryContentWithErrorChecksum()).result()).isEqualTo("123456780 ERR");
    }

    @Test
    void should_append_ill_while_any_unit_is_illegal() {
        assertThat(new Entry(illegalContent()).result()).isEqualTo("69357641? ILL");
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
            " _  _  _  _  _  _  _  _  _ ",
            "|_||_||_||_||_||_||_||_||_|",
            "|_| _| _| _| _| _| _| _| _|",
            "                           "
        );
    }

    private List<String> entryContentWithErrorChecksum() {
        return Arrays.asList(
            "    _  _     _  _  _  _  _ ",
            "  | _| _||_||_ |_   ||_|| |",
            "  ||_  _|  | _||_|  ||_||_|",
            "                           "
        );
    }

    private List<String> malformedContent() {
        return Arrays.asList(
            " _  _  _  _  _  _       ",
            "|_ |_| _||_   ||_ |_|  |",
            "|_| _| _| _|  ||_|  |  |",
            "                        "
        );
    }

    private List<String> illegalContent() {
        return Arrays.asList(
            " _  _  _  _  _  _          ",
            "|_ |_| _||_   ||_ |_|  | _ ",
            "|_| _| _| _|  ||_|  |  |   ",
            "                           "
        );
    }
}