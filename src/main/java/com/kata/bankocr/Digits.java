package com.kata.bankocr;

import static org.apache.commons.lang3.StringUtils.join;

public class Digits {
    public static final String ZERO = defineDigit(
        " _ ",
        "| |",
        "|_|",
        "   "
    );

    public static final String ONE = defineDigit(
        "   ",
        "  |",
        "  |",
        "   "
    );

    public static final String TWO = defineDigit(
        " _ ",
        " _|",
        "|_ ",
        "   "
    );

    public static final String THREE = defineDigit(
        " _ ",
        " _|",
        " _|",
        "   "
    );

    public static final String FOUR = defineDigit(
        "   ",
        "|_|",
        "  |",
        "   "
    );

    public static final String FIVE = defineDigit(
        " _ ",
        "|_ ",
        " _|",
        "   "
    );

    public static final String SIX = defineDigit(
        " _ ",
        "|_ ",
        "|_|",
        "   "
    );

    public static final String SEVEN = defineDigit(
        " _ ",
        "  |",
        "  |",
        "   "
    );

    public static final String EIGHT = defineDigit(
        " _ ",
        "|_|",
        "|_|",
        "   "
    );

    public static final String NINE = defineDigit(
        " _ ",
        "|_|",
        " _|",
        "   "
    );

    private static String defineDigit(String... lines) {
        return join(lines);
    }
}
