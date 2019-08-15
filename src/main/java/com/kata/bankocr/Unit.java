package com.kata.bankocr;

import java.util.List;
import java.util.Objects;

public class Unit {
    private final List<String> content;

    public Unit(List<String> content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return content.equals(unit.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    public String recognize() {
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
        throw new MalformedUnitException();
    }
}
