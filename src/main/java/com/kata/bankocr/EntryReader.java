package com.kata.bankocr;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;

public class EntryReader {
    private final BufferedReader input;

    public EntryReader(BufferedReader input) {
        this.input = input;
    }

    public List<Entry> readAll() {
        return Arrays.asList(new Entry(), new Entry());
    }
}
