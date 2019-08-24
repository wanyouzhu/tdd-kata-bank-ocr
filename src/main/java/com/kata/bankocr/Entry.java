package com.kata.bankocr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        List<String> candidates = new ArrayList<>();
        for (int i = 0; i < units.size(); ++i) {
            StringBuilder unitsToTry = new StringBuilder(units.stream().map(Unit::result).collect(joining()));
            for (String candidate : units.get(i).candidates()) {
                unitsToTry.setCharAt(i, candidate.charAt(0));
                if (isCorrect(unitsToTry.toString())) {
                    candidates.add(unitsToTry.toString());
                }
            }
        }
        if (candidates.size() == 1) {
            result = String.join(", ", candidates);
        } else if (!candidates.isEmpty()) {
            candidates.sort(String::compareTo);
            result = result.substring(0, 9) + " AMB [" + candidates.stream().map(x -> "'" + x + "'").collect(joining(", ")) + "]";
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
        return unitIndices().map(i -> (NUMBER_OF_UNITS_PER_ENTRY - i) * (result.charAt(i) - '0')).sum() % 11;
    }

    private IntStream unitIndices() {
        return IntStream.range(0, NUMBER_OF_UNITS_PER_ENTRY);
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
        return unitIndices().mapToObj(i -> extractUnit(i, content)).collect(toList());
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
