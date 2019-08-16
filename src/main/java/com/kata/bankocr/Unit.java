package com.kata.bankocr;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Unit {
    private final String content;
    private final String result;

    public Unit(String content) {
        this.content = content;
        this.result = recognize(content);
    }

    public String result() {
        return result;
    }

    private String recognize(String content) {
        if (content.equals(Digits.ZERO)) return "0";
        if (content.equals(Digits.ONE)) return "1";
        if (content.equals(Digits.TWO)) return "2";
        if (content.equals(Digits.THREE)) return "3";
        if (content.equals(Digits.FOUR)) return "4";
        if (content.equals(Digits.FIVE)) return "5";
        if (content.equals(Digits.SIX)) return "6";
        if (content.equals(Digits.SEVEN)) return "7";
        if (content.equals(Digits.EIGHT)) return "8";
        if (content.equals(Digits.NINE)) return "9";
        return "?";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return result.equals(unit.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    public List<String> candidates() {
        return sensitiveIndices().mapToObj(this::resolveCandidate).filter(x -> !x.equals("?")).collect(toList());
    }

    private IntStream sensitiveIndices() {
        return IntStream.range(0, Digits.EIGHT.length()).filter(i -> Digits.EIGHT.charAt(i) != ' ');
    }

    private String resolveCandidate(int i) {
        StringBuilder builder = new StringBuilder(content);
        builder.setCharAt(i, content.charAt(i) != Digits.EIGHT.charAt(i) ? Digits.EIGHT.charAt(i) : ' ');
        return recognize(builder.toString());
    }
}
