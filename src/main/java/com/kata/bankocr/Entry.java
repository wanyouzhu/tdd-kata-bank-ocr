package com.kata.bankocr;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Entry {
    private static final int CHARS_PER_UNIT_LINE = 3;
    private final List<String> content;

    public Entry(List<String> content) {
        this.content = content;
        if (!content.stream().allMatch(x -> x.length() == CHARS_PER_UNIT_LINE * 9)) {
            throw new MalformedEntryException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return content.equals(entry.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    public String recognize() {
        return IntStream.range(0, 9).mapToObj(this::createUnit).map(Unit::recognize).collect(joining());
    }

    private Unit createUnit(int unitIndex) {
        return new Unit(content.stream().map(x -> extractUnitLine(unitIndex, x)).collect(toList()));
    }

    private String extractUnitLine(int unitIndex, String entryLine) {
        int unitStart = unitIndex * CHARS_PER_UNIT_LINE;
        return entryLine.substring(unitStart, unitStart + CHARS_PER_UNIT_LINE);
    }
}
