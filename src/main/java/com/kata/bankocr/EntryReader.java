package com.kata.bankocr;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EntryReader {
    private final BufferedReader input;

    public EntryReader(BufferedReader input) {
        this.input = input;
    }

    public List<Entry> readAll() {
        List<String> lines = input.lines().collect(Collectors.toList());
        int numberOfEntries = lines.size() / 4;
        return IntStream.range(0, numberOfEntries).mapToObj(i -> new Entry(lines.subList(i * 4, i * 4 + 4))).collect(Collectors.toList());
    }
}
