package com.kata.bankocr;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Entry {
    private final List<String> content;

    public Entry(List<String> content) {
        this.content = content;
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

    public String resolve() {
        return IntStream.range(0, 9).mapToObj(this::createUnit).map(Unit::resolve).collect(Collectors.joining());
    }

    private Unit createUnit(int index) {
        return new Unit(content.stream().map(x -> x.substring(index * 3, index * 3 + 3)).collect(Collectors.toList()));
    }
}
