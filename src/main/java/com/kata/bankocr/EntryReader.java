package com.kata.bankocr;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class EntryReader {
    private static final int LINES_PER_ENTRY = 4;
    private final BufferedReader input;

    public EntryReader(BufferedReader input) {
        this.input = input;
    }

    public List<Entry> readAll() {
        List<String> lines = readAllLines();
        ensureInputIsCorrect(lines);
        return convertIntoEntries(lines);
    }

    private List<Entry> convertIntoEntries(List<String> lines) {
        return IntStream.range(0, getNumberOfEntries(lines)).mapToObj(i -> extractEntry(lines, i)).collect(toList());
    }

    private List<String> readAllLines() {
        return input.lines().collect(toList());
    }

    private void ensureInputIsCorrect(List<String> lines) {
        if (lines.size() % LINES_PER_ENTRY != 0) throw new MalformedInputException();
    }

    private int getNumberOfEntries(List<String> lines) {
        return lines.size() / LINES_PER_ENTRY;
    }

    private Entry extractEntry(List<String> lines, int index) {
        int entryStart = index * LINES_PER_ENTRY;
        int entryEnd = entryStart + LINES_PER_ENTRY;
        return new Entry(lines.subList(entryStart, entryEnd));
    }
}
