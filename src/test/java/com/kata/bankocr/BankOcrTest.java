package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static com.kata.bankocr.TestDataSet.lines;
import static org.assertj.core.api.Assertions.assertThat;

class BankOcrTest {
    @Test
    void should_recognize_input_file_and_produce_number_list_file() {
        // Given
        StringWriter output = new StringWriter();
        BufferedReader input = new BufferedReader(new StringReader(lines(
            "    _  _     _  _  _  _  _ ",
            "  | _| _||_||_ |_   ||_||_|",
            "  ||_  _|  | _||_|  ||_| _|",
            "                           ",
            " _  _  _  _  _  _  _  _  _ ",
            "|_||_||_||_||_||_||_||_||_|",
            " _| _| _| _| _| _| _| _| _|",
            "                           "
        )));

        // When
        new BankOcr().recognize(input, new BufferedWriter(output));

        // Then
        assertThat(output.toString()).isEqualTo(lines(
            "123456789",
            "999999999"
        ));
    }
}
