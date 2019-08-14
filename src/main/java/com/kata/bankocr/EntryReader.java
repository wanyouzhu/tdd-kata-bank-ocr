package com.kata.bankocr;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EntryReader {
    private static final int LINES_PER_ENTRY = 4;
    private final BufferedReader input;

    public EntryReader(BufferedReader input) {
        this.input = input;
    }

    public List<Entry> readAll() {
        List<String> lines = input.lines().collect(Collectors.toList());
        int numberOfEntries = lines.size() / LINES_PER_ENTRY;
        return IntStream.range(0, numberOfEntries).mapToObj(i -> extractEntry(lines, i)).collect(Collectors.toList());
    }

    private Entry extractEntry(List<String> lines, int index) {
        return new Entry(lines.subList(index * LINES_PER_ENTRY, index * LINES_PER_ENTRY + LINES_PER_ENTRY));
    }
}
