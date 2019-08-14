package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.apache.commons.lang3.StringUtils.join;
import static org.assertj.core.api.Assertions.assertThat;

class EntryReaderTest {
    @Test
    void should_read_correct_number_of_entries_from_input() {
        EntryReader entryReader = new EntryReader(input());
        assertThat(entryReader.readAll().size()).isEqualTo(2);
    }

    private BufferedReader input() {
        return new BufferedReader(new StringReader(join(new String[]{
            "    _  _     _  _  _  _  _ ",
            "  | _| _||_||_ |_   ||_||_|",
            "  ||_  _|  | _||_|  ||_| _|",
            "                           ",
            " _  _  _  _  _  _        _ ",
            "|_ |_| _||_   ||_ |_|  ||_|",
            "|_| _| _| _|  ||_|  |  ||_|",
            "                           ",
        }, "\n")));
    }
}
