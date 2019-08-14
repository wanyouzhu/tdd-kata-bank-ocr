package com.kata.bankocr;

import java.util.List;
import java.util.Objects;

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
}
