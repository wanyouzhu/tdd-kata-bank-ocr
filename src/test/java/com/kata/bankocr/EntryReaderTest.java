package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.join;
import static org.assertj.core.api.Assertions.assertThat;

public class EntryReaderTest {

    @Test
    void should_read_entries_from_input() {
        BufferedReader input = correctInput();
        EntryReader entryReader = new EntryReader(input);
        List<Entry> entries = entryReader.readAll();
        assertThat(entries.size()).isEqualTo(2);
    }

    private BufferedReader correctInput() {
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
