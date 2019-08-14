package com.kata.bankocr;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.apache.commons.lang3.StringUtils.join;
import static org.assertj.core.api.Assertions.assertThat;

class BankOcrTest {
    @Disabled
    @Test
    void should_recognize_input_file_and_produce_number_list_file() {
        // Given
        StringWriter output = new StringWriter();
        BufferedReader input = new BufferedReader(new StringReader(join(new String[]{
            "    _  _     _  _  _  _  _ ",
            "  | _| _||_||_ |_   ||_||_|",
            "  ||_  _|  | _||_|  ||_| _|",
            "                           ",
            " _  _  _  _  _  _        _ ",
            "|_ |_| _||_   ||_ |_|  ||_|",
            "|_| _| _| _|  ||_|  |  ||_|",
            "                           ",
        }, "\n")));

        // When
        new BankOcr().recognize(input, new BufferedWriter(output));

        // Then
        assertThat(output.toString()).isEqualTo(join(new String[]{
            "123456789",
            "693576418"
        }, "\n"));
    }
}
