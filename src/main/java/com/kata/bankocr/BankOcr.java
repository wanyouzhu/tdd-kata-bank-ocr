package com.kata.bankocr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class BankOcr {
    public void recognize(BufferedReader input, BufferedWriter output) {
        write(output, collectResult(getEntries(input)));
    }

    private String collectResult(List<Entry> entries) {
        return entries.stream().map(Entry::result).collect(joining("\n"));
    }

    private List<Entry> getEntries(BufferedReader input) {
        return new EntryReader(input).readAll();
    }

    private void write(BufferedWriter output, String content) {
        try {
            output.write(content);
            output.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
