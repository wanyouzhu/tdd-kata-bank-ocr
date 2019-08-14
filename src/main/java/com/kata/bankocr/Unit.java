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
}
