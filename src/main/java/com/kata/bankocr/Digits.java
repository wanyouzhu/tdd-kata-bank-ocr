package com.kata.bankocr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Digits {
    public static final List<String> ZERO = defineDigit(
        " _ ",
        "| |",
        "|_|",
        "   "
    );

    public static final List<String> ONE = defineDigit(
        "   ",
        "  |",
        "  |",
        "   "
    );

    public static final List<String> TWO = defineDigit(
        " _ ",
        " _|",
        "|_ ",
        "   "
    );

    public static final List<String> THREE = defineDigit(
        " _ ",
        " _|",
        " _|",
        "   "
    );

    public static final List<String> FOUR = defineDigit(
        "   ",
        "|_|",
        "  |",
        "   "
    );

    public static final List<String> FIVE = defineDigit(
        " _ ",
        "|_ ",
        " _|",
        "   "
    );

    public static final List<String> SIX = defineDigit(
        " _ ",
        "|_ ",
        "|_|",
        "   "
    );

    private static List<String> defineDigit(String... lines) {
        return Collections.unmodifiableList(Arrays.asList(lines));
    }
}
