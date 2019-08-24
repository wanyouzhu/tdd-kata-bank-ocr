package com.kata.bankocr;

import com.google.common.collect.Sets;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Entry {
    private static final int NUMBER_OF_UNITS_PER_ENTRY = 9;
    private static final int CHARS_PER_UNIT_LINE = 3;
    private final List<Unit> units;
    private String result;

    public Entry(List<String> content) {
        checkContent(content);
        this.units = extractUnits(content);
        this.result = recognize(units);
        checkResult();
        recoverIfNeed();
    }

    private void recoverIfNeed() {
        if (!hasError()) return;
        Set<List<String>> lists = Sets.cartesianProduct(units.stream().map(Unit::candidates).map(LinkedHashSet::new).collect(toList()));
        List<String> collect = lists.stream().map(x -> String.join("", x)).filter(this::isCorrect).collect(toList());
        if (!collect.isEmpty()) {
            result = String.join(" ", collect);
        }
    }

    private boolean isCorrect(String candidate) {
        return IntStream.range(0, 9).map(i -> (9 - i) * (candidate.charAt(i) - '0')).sum() % 11 == 0;
    }

    private void checkResult() {
        validateUnits();
        validateChecksum();
    }

    private void validateUnits() {
        if (result.chars().anyMatch(x -> x == '?')) {
            result = result + " ILL";
        }
    }

    private void validateChecksum() {
        if (!hasError() && calculateChecksum() != 0) {
            result = result + " ERR";
        }
    }

    private boolean hasError() {
        return result.length() != 9;
    }

    private int calculateChecksum() {
        return IntStream.range(0, 9).map(i -> (9 - i) * (result.charAt(i) - '0')).sum() % 11;
    }

    private void checkContent(List<String> content) {
        if (!content.stream().allMatch(x -> x.length() == CHARS_PER_UNIT_LINE * NUMBER_OF_UNITS_PER_ENTRY)) {
            throw new MalformedEntryException();
        }
    }

    private String recognize(List<Unit> units) {
        return units.stream().map(Unit::result).collect(joining());
    }

    private List<Unit> extractUnits(List<String> content) {
        return IntStream.range(0, NUMBER_OF_UNITS_PER_ENTRY).mapToObj(i -> extractUnit(i, content)).collect(toList());
    }

    private Unit extractUnit(int unitIndex, List<String> content) {
        return new Unit(content.stream().map(x -> extractUnitLine(unitIndex, x)).collect(joining()));
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
