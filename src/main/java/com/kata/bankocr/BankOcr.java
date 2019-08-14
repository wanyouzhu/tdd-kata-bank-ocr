package com.kata.bankocr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class BankOcr {
    public void recognize(BufferedReader input, BufferedWriter output) {
        new EntryReader(input).readAll().stream().map(Entry::resolve).forEachOrdered(x -> writeLine(output, x));
        flushOutput(output);
    }

    private void writeLine(BufferedWriter output, String line) {
        try {
            output.write(line);
            output.write('\n');
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
