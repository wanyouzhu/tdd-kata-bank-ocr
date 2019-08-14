package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.join;
import static org.assertj.core.api.Assertions.assertThat;

class EntryReaderTest {
    @Test
    void should_read_correct_number_of_entries_from_input() {
        EntryReader entryReader = new EntryReader(input());
        assertThat(entryReader.readAll().size()).isEqualTo(2);
    }

    @Test
    void should_read_correct_entries_from_input() {
        EntryReader entryReader = new EntryReader(input());
        List<Entry> entries = entryReader.readAll();
        assertThat(entries.get(0)).isEqualTo(new Entry(firstBlockOfInput()));
        assertThat(entries.get(1)).isEqualTo(new Entry(secondBlockOfInput()));
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

    private List<String> firstBlockOfInput() {
        return Arrays.asList(
            "    _  _     _  _  _  _  _ ",
            "  | _| _||_||_ |_   ||_||_|",
            "  ||_  _|  | _||_|  ||_| _|",
            "                           "
        );
    }

    private List<String> secondBlockOfInput() {
        return Arrays.asList(
            " _  _  _  _  _  _        _ ",
            "|_ |_| _||_   ||_ |_|  ||_|",
            "|_| _| _| _|  ||_|  |  ||_|",
            "                           "
        );
    }
}
