package com.kata.bankocr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static java.util.stream.Collectors.joining;

public class BankOcr {
    public void recognize(BufferedReader input, BufferedWriter output) {
        write(output, new EntryReader(input).readAll().stream().map(Entry::recognize).collect(joining("\n")));
        flushOutput(output);
    }

    private void write(BufferedWriter output, String line) {
        try {
            output.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void flushOutput(BufferedWriter output) {
        try {
            output.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
