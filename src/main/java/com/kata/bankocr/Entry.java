package com.kata.bankocr;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Entry {
    private static final int CHARS_PER_UNIT_LINE = 3;
    private final String result;

    public Entry(List<String> content) {
        checkContent(content);
        this.result = recognize(content);
    }

    private void checkContent(List<String> content) {
        if (!content.stream().allMatch(x -> x.length() == CHARS_PER_UNIT_LINE * 9)) {
            throw new MalformedEntryException();
        }
    }

    private String recognize(List<String> content) {
        return IntStream.range(0, 9).mapToObj(unitIndex -> createUnit(unitIndex, content)).map(Unit::result).collect(joining());
    }

    private Unit createUnit(int unitIndex, List<String> content) {
        return new Unit(content.stream().map(x -> extractUnitLine(unitIndex, x)).collect(toList()));
    }

    private String extractUnitLine(int unitIndex, String entryLine) {
        int unitStart = unitIndex * CHARS_PER_UNIT_LINE;
        return entryLine.substring(unitStart, unitStart + CHARS_PER_UNIT_LINE);
    }

    public String result() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return result.equals(entry.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
