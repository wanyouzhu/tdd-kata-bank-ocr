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
    private String result;

    public Entry(List<String> content) {
        this.result = recognize(extractUnits(content));
    }

    private String recognize(List<Unit> units) {
        String recognized = recognizeFromUnits(units);
        return isCorrect(recognized) ? recognized : recover(recognized, units);
    }

    private Unit extractUnit(int unitIndex, List<String> content) {
        return new Unit(content.stream().map(x -> extractUnitLine(unitIndex, x)).collect(joining()));
    }

    private String extractUnitLine(int unitIndex, String entryLine) {
        int unitStart = unitIndex * CHARS_PER_UNIT_LINE;
        return entryLine.substring(unitStart, unitStart + CHARS_PER_UNIT_LINE);
    }

    private boolean isCorrect(String recognized) {
        return !recognized.contains("?") && isChecksumCorrect(recognized);
    }

    private IntStream unitIndices() {
        return IntStream.range(0, NUMBER_OF_UNITS_PER_ENTRY);
    }

    private String recover(String recognized, List<Unit> units) {
        List<String> candidates = getRecoveredCandidates(units);

        if (candidates.isEmpty()) {
            return recognized + " " + (recognized.contains("?") ? "ILL" : "ERR");
        }

        if (candidates.size() == 1) {
            return String.join(", ", candidates);
        }

        candidates.sort(String::compareTo);
        return recognized + " AMB [" + candidates.stream().map(x -> "'" + x + "'").collect(joining(", ")) + "]";
    }

    private List<String> getRecoveredCandidates(List<Unit> units) {
        List<String> candidates = new ArrayList<>();
        for (int i = 0; i < units.size(); ++i) {
            StringBuilder unitsToTry = new StringBuilder(recognizeFromUnits(units));
            for (String candidate : units.get(i).candidates()) {
                unitsToTry.setCharAt(i, candidate.charAt(0));
                if (isChecksumCorrect(unitsToTry.toString())) {
                    candidates.add(unitsToTry.toString());
                }
            }
        }
        return candidates;
    }

    private boolean isChecksumCorrect(String candidate) {
        return unitIndices().map(i -> (NUMBER_OF_UNITS_PER_ENTRY - i) * (candidate.charAt(i) - '0')).sum() % 11 == 0;
    }

    private String recognizeFromUnits(List<Unit> units) {
        return units.stream().map(Unit::result).collect(joining());
    }

    private List<Unit> extractUnits(List<String> content) {
        checkContent(content);
        return unitIndices().mapToObj(i -> extractUnit(i, content)).collect(toList());
    }

    private void checkContent(List<String> content) {
        if (!content.stream().allMatch(x -> x.length() == CHARS_PER_UNIT_LINE * NUMBER_OF_UNITS_PER_ENTRY)) {
            throw new MalformedEntryException();
        }
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
